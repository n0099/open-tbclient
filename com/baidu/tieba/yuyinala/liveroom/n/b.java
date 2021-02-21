package com.baidu.tieba.yuyinala.liveroom.n;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.n.a;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class b {
    private WeakReference<a> hNt;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private String mUserId;
    private h oyd;
    private a.b oye = new a.b() { // from class: com.baidu.tieba.yuyinala.liveroom.n.b.1
        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VV(String str) {
            b.this.oyd.x(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VW(String str) {
            b.this.oyd.y(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VX(String str) {
            b.this.oyd.z(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VY(String str) {
            b.this.oyd.A(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void VZ(String str) {
            b.this.oyd.B(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void Wa(String str) {
            b.this.oyd.C(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void onCancel() {
        }
    };

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, String str4, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.oyd = new h(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str4;
            this.mRoomId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hNt != null && this.hNt.get() != null) {
                a aVar = this.hNt.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hNt.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.oye);
            aVar2.a(personUserData, z, str4);
            this.hNt = new WeakReference<>(aVar2);
        }
    }

    public void a(h.a aVar) {
        this.oyd.a(aVar);
    }

    public void bkp() {
        a aVar;
        if (this.hNt != null && this.hNt.get() != null && (aVar = this.hNt.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hNt != null && this.hNt.get() != null) {
            a aVar = this.hNt.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hNt.clear();
        }
    }
}
