package com.baidu.tieba.yuyinala.liveroom.n;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.n.a;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class b {
    private WeakReference<a> hIH;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private String mUserId;
    private h onM;
    private a.b onN = new a.b() { // from class: com.baidu.tieba.yuyinala.liveroom.n.b.1
        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void UK(String str) {
            b.this.onM.u(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void UL(String str) {
            b.this.onM.x(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void UM(String str) {
            b.this.onM.y(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void UN(String str) {
            b.this.onM.z(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void UO(String str) {
            b.this.onM.A(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void UP(String str) {
            b.this.onM.B(str, b.this.mRoomId, b.this.mGroupId);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.n.a.b
        public void onCancel() {
        }
    };

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, String str4, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.onM = new h(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str4;
            this.mRoomId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hIH != null && this.hIH.get() != null) {
                a aVar = this.hIH.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hIH.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.onN);
            aVar2.a(personUserData, z, str4);
            this.hIH = new WeakReference<>(aVar2);
        }
    }

    public void a(h.a aVar) {
        this.onM.a(aVar);
    }

    public void bjV() {
        a aVar;
        if (this.hIH != null && this.hIH.get() != null && (aVar = this.hIH.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hIH != null && this.hIH.get() != null) {
            a aVar = this.hIH.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hIH.clear();
        }
    }
}
