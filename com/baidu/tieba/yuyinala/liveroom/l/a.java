package com.baidu.tieba.yuyinala.liveroom.l;

import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.an.c;
import com.baidu.live.audiolive.e;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.tieba.yuyinala.liveroom.introduce.d;
import com.baidu.tieba.yuyinala.liveroom.roomcard.f;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a implements e {
    private ab bzn;
    private com.baidu.live.an.a hau;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void ah(ab abVar) {
        this.bzn = abVar;
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("listener", this);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501015, hashMap));
    }

    @Override // com.baidu.live.audiolive.e
    public void zN() {
        new f(getPageContext().getPageActivity(), this.bzn).ai(this.bzn);
    }

    @Override // com.baidu.live.audiolive.e
    public void zO() {
        if (this.bzn != null && this.bzn.aKu != null) {
            new d(getPageContext().getPageActivity()).ae(this.bzn);
        }
    }

    @Override // com.baidu.live.audiolive.e
    public void zP() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bzn);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501007, hashMap));
    }

    @Override // com.baidu.live.audiolive.e
    public void zQ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bzn);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501006, hashMap));
    }

    @Override // com.baidu.live.audiolive.e
    public void zR() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bzn);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501008, hashMap));
    }

    @Override // com.baidu.live.audiolive.e
    public void fr(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        if (this.hau == null) {
            this.hau = new com.baidu.live.an.a(getPageContext().getPageActivity());
        }
        c cVar = new c();
        if (this.bzn != null && this.bzn.aKu != null) {
            if (str.contains("?")) {
                str = str + "&live_id=" + this.bzn.aKu.live_id + "&room_id=" + this.bzn.aKu.aVk + "&subapp_type=" + TbConfig.getSubappType() + "&_sdk_version=" + TbConfig.SDK_VERSION;
            } else {
                str = str + "?live_id=" + this.bzn.aKu.live_id + "&room_id=" + this.bzn.aKu.aVk + "&subapp_type=" + TbConfig.getSubappType() + "&_sdk_version=" + TbConfig.SDK_VERSION;
            }
        }
        cVar.url = str;
        this.hau.alaLiveShowData = com.baidu.live.ao.a.Ym().Yt();
        this.hau.a(cVar);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Au() {
        super.Au();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }
}
