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
    private RequestGroupLocModel fcp;
    private a fcq;
    private double longitude = 0.0d;
    private double latitude = 0.0d;
    private BdUniqueId unique_id = null;
    private final a.InterfaceC0017a locationCallBack = new a.InterfaceC0017a() { // from class: com.baidu.tieba.im.util.b.1
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            switch (i) {
                case 0:
                    if (address != null) {
                        b.this.latitude = address.getLatitude();
                        b.this.longitude = address.getLongitude();
                        b.this.fcp.setLat(String.valueOf(address.getLatitude()));
                        b.this.fcp.setLng(String.valueOf(address.getLongitude()));
                        b.this.fcp.setGroupId(0L);
                        b.this.fcp.sendMessage();
                        return;
                    }
                    return;
                case 1:
                case 2:
                case 3:
                    b.this.fcq.aQb();
                    return;
                case 4:
                case 5:
                    b.this.fcq.aQa();
                    return;
                default:
                    return;
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fcr = new com.baidu.adp.framework.listener.c(103010) { // from class: com.baidu.tieba.im.util.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103010) {
                b.this.fcq.aQa();
            } else if (!(socketResponsedMessage instanceof ResponseRequestGroupLocMessage)) {
                b.this.fcq.aQa();
            } else {
                ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) socketResponsedMessage;
                if (responseRequestGroupLocMessage.getError() != 0) {
                    b.this.fcq.aQa();
                    return;
                }
                Iterator<String> iteraotrOfBusinessAreaList = responseRequestGroupLocMessage.getIteraotrOfBusinessAreaList();
                ArrayList arrayList = new ArrayList();
                while (iteraotrOfBusinessAreaList.hasNext()) {
                    arrayList.add(iteraotrOfBusinessAreaList.next());
                }
                String position = responseRequestGroupLocMessage.getPosition();
                if ((position == null || position.equals("")) && arrayList.size() < 1) {
                    b.this.fcq.aQa();
                } else {
                    b.this.fcq.a(position, arrayList, b.this.latitude, b.this.longitude);
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, List<String> list, double d, double d2);

        void aQa();

        void aQb();
    }

    public b(a aVar) {
        this.fcp = null;
        this.fcq = null;
        this.fcp = new RequestGroupLocModel();
        this.fcq = aVar;
        this.fcr.setTag(this.unique_id);
        MessageManager.getInstance().registerListener(this.fcr);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        this.fcp.setUniqueId(bdUniqueId);
    }

    public void Rt() {
        com.baidu.adp.lib.d.a.iW().a(true, this.locationCallBack);
    }

    public void cancelLoad() {
        this.fcp.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fcr);
    }
}
