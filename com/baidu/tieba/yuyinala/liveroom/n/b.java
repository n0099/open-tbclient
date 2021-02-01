package com.baidu.tieba.yuyinala.liveroom.n;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.n.a;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class b {
    private WeakReference<a> hNf;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private String mUserId;
    private h oxD;
    private a.b oxE = new a.b() { // from class: com.baidu.tieba.yuyinala.liveroom.n.b.1
        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VJ(String str) {
            b.this.oxD.x(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VK(String str) {
            b.this.oxD.y(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VL(String str) {
            b.this.oxD.z(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VM(String str) {
            b.this.oxD.A(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VN(String str) {
            b.this.oxD.B(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VO(String str) {
            b.this.oxD.C(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void onCancel() {
        }
    };

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, String str4, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.oxD = new h(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str4;
            this.mRoomId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hNf != null && this.hNf.get() != null) {
                a aVar = this.hNf.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hNf.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.oxE);
            aVar2.a(personUserData, z, str4);
            this.hNf = new WeakReference<>(aVar2);
        }
    }

    public void a(h.a aVar) {
        this.oxD.a(aVar);
    }

    public void bkp() {
        a aVar;
        if (this.hNf != null && this.hNf.get() != null && (aVar = this.hNf.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hNf != null && this.hNf.get() != null) {
            a aVar = this.hNf.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hNf.clear();
        }
    }
}
