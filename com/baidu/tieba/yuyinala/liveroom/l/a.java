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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a implements e {
    private ab bxN;
    private com.baidu.live.an.a gYL;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void ah(ab abVar) {
        this.bxN = abVar;
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("listener", this);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501015, hashMap));
    }

    @Override // com.baidu.live.audiolive.e
    public void zK() {
        new f(getPageContext().getPageActivity(), this.bxN).ai(this.bxN);
    }

    @Override // com.baidu.live.audiolive.e
    public void zL() {
        if (this.bxN != null && this.bxN.aIU != null) {
            new d(getPageContext().getPageActivity()).ae(this.bxN);
        }
    }

    @Override // com.baidu.live.audiolive.e
    public void zM() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bxN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501007, hashMap));
    }

    @Override // com.baidu.live.audiolive.e
    public void zN() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bxN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501006, hashMap));
    }

    @Override // com.baidu.live.audiolive.e
    public void zO() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bxN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501008, hashMap));
    }

    @Override // com.baidu.live.audiolive.e
    public void fl(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        if (this.gYL == null) {
            this.gYL = new com.baidu.live.an.a(getPageContext().getPageActivity());
        }
        c cVar = new c();
        if (this.bxN != null && this.bxN.aIU != null) {
            if (str.contains("?")) {
                str = str + "&live_id=" + this.bxN.aIU.live_id + "&room_id=" + this.bxN.aIU.aTK + "&subapp_type=" + TbConfig.getSubappType() + "&_sdk_version=" + TbConfig.SDK_VERSION;
            } else {
                str = str + "?live_id=" + this.bxN.aIU.live_id + "&room_id=" + this.bxN.aIU.aTK + "&subapp_type=" + TbConfig.getSubappType() + "&_sdk_version=" + TbConfig.SDK_VERSION;
            }
        }
        cVar.url = str;
        this.gYL.alaLiveShowData = com.baidu.live.ao.a.Yj().Yq();
        this.gYL.a(cVar);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Ar() {
        super.Ar();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }
}
