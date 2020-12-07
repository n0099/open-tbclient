package com.baidu.tieba.yuyinala.liveroom.j;

import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.e.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.tieba.yuyinala.liveroom.introduce.d;
import com.baidu.tieba.yuyinala.liveroom.roomcard.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a implements c {
    private w bur;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void ad(w wVar) {
        this.bur = wVar;
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("listener", this);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501015, hashMap));
    }

    @Override // com.baidu.live.e.c
    public void DG() {
        new f(getPageContext().getPageActivity()).ae(this.bur);
    }

    @Override // com.baidu.live.e.c
    public void DH() {
        if (this.bur != null && this.bur.aKL != null) {
            new d(getPageContext().getPageActivity()).ac(this.bur);
        }
    }

    @Override // com.baidu.live.e.c
    public void DI() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bur);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501007, hashMap));
    }

    @Override // com.baidu.live.e.c
    public void DJ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bur);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501006, hashMap));
    }

    @Override // com.baidu.live.e.c
    public void DK() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bur);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501008, hashMap));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void En() {
        super.En();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }
}
