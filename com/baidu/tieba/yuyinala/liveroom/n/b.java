package com.baidu.tieba.yuyinala.liveroom.n;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.n.a;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class b {
    private WeakReference<a> hNn;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private String mUserId;
    private h osu;
    private a.b osv = new a.b() { // from class: com.baidu.tieba.yuyinala.liveroom.n.b.1
        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VT(String str) {
            b.this.osu.x(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VU(String str) {
            b.this.osu.y(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VV(String str) {
            b.this.osu.z(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VW(String str) {
            b.this.osu.A(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VX(String str) {
            b.this.osu.B(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VY(String str) {
            b.this.osu.C(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void onCancel() {
        }
    };

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, String str4, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.osu = new h(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str4;
            this.mRoomId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hNn != null && this.hNn.get() != null) {
                a aVar = this.hNn.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hNn.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.osv);
            aVar2.a(personUserData, z, str4);
            this.hNn = new WeakReference<>(aVar2);
        }
    }

    public void a(h.a aVar) {
        this.osu.a(aVar);
    }

    public void bnO() {
        a aVar;
        if (this.hNn != null && this.hNn.get() != null && (aVar = this.hNn.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hNn != null && this.hNn.get() != null) {
            a aVar = this.hNn.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hNn.clear();
        }
    }
}
