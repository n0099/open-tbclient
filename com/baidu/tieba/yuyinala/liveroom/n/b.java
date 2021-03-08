package com.baidu.tieba.yuyinala.liveroom.n;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.n.a;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class b {
    private WeakReference<a> hPc;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private String mUserId;
    private h oAi;
    private a.b oAj = new a.b() { // from class: com.baidu.tieba.yuyinala.liveroom.n.b.1
        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void Wc(String str) {
            b.this.oAi.x(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void Wd(String str) {
            b.this.oAi.y(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void We(String str) {
            b.this.oAi.z(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void Wf(String str) {
            b.this.oAi.A(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void Wg(String str) {
            b.this.oAi.B(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void Wh(String str) {
            b.this.oAi.C(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void onCancel() {
        }
    };

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, String str4, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.oAi = new h(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str4;
            this.mRoomId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hPc != null && this.hPc.get() != null) {
                a aVar = this.hPc.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hPc.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.oAj);
            aVar2.a(personUserData, z, str4);
            this.hPc = new WeakReference<>(aVar2);
        }
    }

    public void a(h.a aVar) {
        this.oAi.a(aVar);
    }

    public void bkr() {
        a aVar;
        if (this.hPc != null && this.hPc.get() != null && (aVar = this.hPc.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hPc != null && this.hPc.get() != null) {
            a aVar = this.hPc.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hPc.clear();
        }
    }
}
