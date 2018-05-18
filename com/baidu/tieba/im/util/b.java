package com.baidu.tieba.im.util;

import android.location.Address;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import com.baidu.tieba.im.model.RequestGroupLocModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private RequestGroupLocModel ejv;
    private a ejw;
    private double longitude = 0.0d;
    private double latitude = 0.0d;
    private BdUniqueId unique_id = null;
    private final a.InterfaceC0006a locationCallBack = new a.InterfaceC0006a() { // from class: com.baidu.tieba.im.util.b.1
        @Override // com.baidu.adp.lib.d.a.InterfaceC0006a
        public void b(int i, String str, Address address) {
            switch (i) {
                case 0:
                    if (address != null) {
                        b.this.latitude = address.getLatitude();
                        b.this.longitude = address.getLongitude();
                        b.this.ejv.setLat(String.valueOf(address.getLatitude()));
                        b.this.ejv.setLng(String.valueOf(address.getLongitude()));
                        b.this.ejv.setGroupId(0L);
                        b.this.ejv.sendMessage();
                        return;
                    }
                    return;
                case 1:
                case 2:
                case 3:
                    b.this.ejw.aBV();
                    return;
                case 4:
                case 5:
                    b.this.ejw.aBU();
                    return;
                default:
                    return;
            }
        }
    };
    private final com.baidu.adp.framework.listener.c ejx = new com.baidu.adp.framework.listener.c(103010) { // from class: com.baidu.tieba.im.util.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103010) {
                b.this.ejw.aBU();
            } else if (!(socketResponsedMessage instanceof ResponseRequestGroupLocMessage)) {
                b.this.ejw.aBU();
            } else {
                ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) socketResponsedMessage;
                if (responseRequestGroupLocMessage.getError() != 0) {
                    b.this.ejw.aBU();
                    return;
                }
                Iterator<String> iteraotrOfBusinessAreaList = responseRequestGroupLocMessage.getIteraotrOfBusinessAreaList();
                ArrayList arrayList = new ArrayList();
                while (iteraotrOfBusinessAreaList.hasNext()) {
                    arrayList.add(iteraotrOfBusinessAreaList.next());
                }
                String position = responseRequestGroupLocMessage.getPosition();
                if ((position == null || position.equals("")) && arrayList.size() < 1) {
                    b.this.ejw.aBU();
                } else {
                    b.this.ejw.a(position, arrayList, b.this.latitude, b.this.longitude);
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, List<String> list, double d, double d2);

        void aBU();

        void aBV();
    }

    public b(a aVar) {
        this.ejv = null;
        this.ejw = null;
        this.ejv = new RequestGroupLocModel();
        this.ejw = aVar;
        this.ejx.setTag(this.unique_id);
        MessageManager.getInstance().registerListener(this.ejx);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        this.ejv.setUniqueId(bdUniqueId);
    }

    public void Ja() {
        com.baidu.adp.lib.d.a.eK().a(true, this.locationCallBack);
    }

    public void cancelLoad() {
        this.ejv.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.ejx);
    }
}
