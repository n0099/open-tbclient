package com.baidu.tieba.yuyinala.liveroom.l;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.l.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private WeakReference<a> hrZ;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private String mUserId;
    private h nYw;
    private a.b nYx = new a.b() { // from class: com.baidu.tieba.yuyinala.liveroom.l.b.1
        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void Iq(String str) {
            b.this.nYw.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void Ir(String str) {
            b.this.nYw.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void Is(String str) {
            b.this.nYw.s(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void It(String str) {
            b.this.nYw.t(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void Iu(String str) {
            b.this.nYw.u(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void Iv(String str) {
            b.this.nYw.x(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void onCancel() {
        }
    };

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, String str4, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.nYw = new h(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str4;
            this.mRoomId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hrZ != null && this.hrZ.get() != null) {
                a aVar = this.hrZ.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hrZ.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.nYx);
            aVar2.a(personUserData, z, str4);
            this.hrZ = new WeakReference<>(aVar2);
        }
    }

    public void a(h.a aVar) {
        this.nYw.a(aVar);
    }

    public void biM() {
        a aVar;
        if (this.hrZ != null && this.hrZ.get() != null && (aVar = this.hrZ.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hrZ != null && this.hrZ.get() != null) {
            a aVar = this.hrZ.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hrZ.clear();
        }
    }
}
