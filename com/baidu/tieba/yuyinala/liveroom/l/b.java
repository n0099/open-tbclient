package com.baidu.tieba.yuyinala.liveroom.l;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.l.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private WeakReference<a> hrG;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private String mUserId;
    private h nZZ;
    private a.b oaa = new a.b() { // from class: com.baidu.tieba.yuyinala.liveroom.l.b.1
        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void HR(String str) {
            b.this.nZZ.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void HS(String str) {
            b.this.nZZ.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void HT(String str) {
            b.this.nZZ.s(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void HU(String str) {
            b.this.nZZ.t(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void HV(String str) {
            b.this.nZZ.u(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void HW(String str) {
            b.this.nZZ.x(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void onCancel() {
        }
    };

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, String str4, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.nZZ = new h(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str4;
            this.mRoomId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hrG != null && this.hrG.get() != null) {
                a aVar = this.hrG.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hrG.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.oaa);
            aVar2.a(personUserData, z, str4);
            this.hrG = new WeakReference<>(aVar2);
        }
    }

    public void a(h.a aVar) {
        this.nZZ.a(aVar);
    }

    public void big() {
        a aVar;
        if (this.hrG != null && this.hrG.get() != null && (aVar = this.hrG.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hrG != null && this.hrG.get() != null) {
            a aVar = this.hrG.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hrG.clear();
        }
    }
}
