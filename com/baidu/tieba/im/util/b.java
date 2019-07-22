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
/* loaded from: classes5.dex */
public class b {
    private RequestGroupLocModel gQw;
    private a gQx;
    private double longitude = 0.0d;
    private double latitude = 0.0d;
    private BdUniqueId unique_id = null;
    private final a.InterfaceC0015a locationCallBack = new a.InterfaceC0015a() { // from class: com.baidu.tieba.im.util.b.1
        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
        public void b(int i, String str, Address address) {
            switch (i) {
                case 0:
                    if (address != null) {
                        b.this.latitude = address.getLatitude();
                        b.this.longitude = address.getLongitude();
                        b.this.gQw.setLat(String.valueOf(address.getLatitude()));
                        b.this.gQw.setLng(String.valueOf(address.getLongitude()));
                        b.this.gQw.setGroupId(0L);
                        b.this.gQw.sendMessage();
                        return;
                    }
                    return;
                case 1:
                case 2:
                case 3:
                    b.this.gQx.bBy();
                    return;
                case 4:
                case 5:
                    b.this.gQx.bBx();
                    return;
                default:
                    return;
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gQy = new com.baidu.adp.framework.listener.c(103010) { // from class: com.baidu.tieba.im.util.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103010) {
                b.this.gQx.bBx();
            } else if (!(socketResponsedMessage instanceof ResponseRequestGroupLocMessage)) {
                b.this.gQx.bBx();
            } else {
                ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) socketResponsedMessage;
                if (responseRequestGroupLocMessage.getError() != 0) {
                    b.this.gQx.bBx();
                    return;
                }
                Iterator<String> iteraotrOfBusinessAreaList = responseRequestGroupLocMessage.getIteraotrOfBusinessAreaList();
                ArrayList arrayList = new ArrayList();
                while (iteraotrOfBusinessAreaList.hasNext()) {
                    arrayList.add(iteraotrOfBusinessAreaList.next());
                }
                String position = responseRequestGroupLocMessage.getPosition();
                if ((position == null || position.equals("")) && arrayList.size() < 1) {
                    b.this.gQx.bBx();
                } else {
                    b.this.gQx.a(position, arrayList, b.this.latitude, b.this.longitude);
                }
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, List<String> list, double d, double d2);

        void bBx();

        void bBy();
    }

    public b(a aVar) {
        this.gQw = null;
        this.gQx = null;
        this.gQw = new RequestGroupLocModel();
        this.gQx = aVar;
        this.gQy.setTag(this.unique_id);
        MessageManager.getInstance().registerListener(this.gQy);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        this.gQw.setUniqueId(bdUniqueId);
    }

    public void aya() {
        com.baidu.adp.lib.d.a.hY().a(true, this.locationCallBack);
    }

    public void cancelLoad() {
        this.gQw.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.gQy);
    }
}
