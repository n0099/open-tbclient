package com.baidu.tieba.yuyinala.liveroom.l;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.l.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private WeakReference<a> hBm;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private String mUserId;
    private h opb;
    private a.b opc = new a.b() { // from class: com.baidu.tieba.yuyinala.liveroom.l.b.1
        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void IG(String str) {
            b.this.opb.t(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void IH(String str) {
            b.this.opb.u(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void II(String str) {
            b.this.opb.x(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void IJ(String str) {
            b.this.opb.y(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void IK(String str) {
            b.this.opb.z(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void IL(String str) {
            b.this.opb.A(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void onCancel() {
        }
    };

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, String str4, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.opb = new h(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str4;
            this.mRoomId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hBm != null && this.hBm.get() != null) {
                a aVar = this.hBm.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hBm.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.opc);
            aVar2.a(personUserData, z, str4);
            this.hBm = new WeakReference<>(aVar2);
        }
    }

    public void a(h.a aVar) {
        this.opb.a(aVar);
    }

    public void blq() {
        a aVar;
        if (this.hBm != null && this.hBm.get() != null && (aVar = this.hBm.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hBm != null && this.hBm.get() != null) {
            a aVar = this.hBm.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hBm.clear();
        }
    }
}
