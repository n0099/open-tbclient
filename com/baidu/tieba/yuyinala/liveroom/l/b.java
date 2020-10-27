package com.baidu.tieba.yuyinala.liveroom.l;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.l.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private WeakReference<a> hmb;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private String mUserId;
    private h nRm;
    private a.b nRn = new a.b() { // from class: com.baidu.tieba.yuyinala.liveroom.l.b.1
        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void HZ(String str) {
            b.this.nRm.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void Ia(String str) {
            b.this.nRm.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void Ib(String str) {
            b.this.nRm.s(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void Ic(String str) {
            b.this.nRm.t(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void Id(String str) {
            b.this.nRm.u(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void Ie(String str) {
            b.this.nRm.x(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.l.a.b
        public void onCancel() {
        }
    };

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, String str4, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.nRm = new h(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str4;
            this.mRoomId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hmb != null && this.hmb.get() != null) {
                a aVar = this.hmb.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hmb.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.nRn);
            aVar2.a(personUserData, z, str4);
            this.hmb = new WeakReference<>(aVar2);
        }
    }

    public void a(h.a aVar) {
        this.nRm.a(aVar);
    }

    public void bgm() {
        a aVar;
        if (this.hmb != null && this.hmb.get() != null && (aVar = this.hmb.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hmb != null && this.hmb.get() != null) {
            a aVar = this.hmb.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hmb.clear();
        }
    }
}
