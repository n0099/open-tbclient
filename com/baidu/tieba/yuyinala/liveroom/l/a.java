package com.baidu.tieba.yuyinala.liveroom.l;

import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.x;
import com.baidu.live.e.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.tieba.yuyinala.liveroom.introduce.d;
import com.baidu.tieba.yuyinala.liveroom.roomcard.f;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a implements c {
    private x buq;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void ah(x xVar) {
        this.buq = xVar;
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("listener", this);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501015, hashMap));
    }

    @Override // com.baidu.live.e.c
    public void za() {
        new f(getPageContext().getPageActivity()).ai(this.buq);
    }

    @Override // com.baidu.live.e.c
    public void zb() {
        if (this.buq != null && this.buq.aGy != null) {
            new d(getPageContext().getPageActivity()).af(this.buq);
        }
    }

    @Override // com.baidu.live.e.c
    public void zc() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.buq);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501007, hashMap));
    }

    @Override // com.baidu.live.e.c
    public void zd() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.buq);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501006, hashMap));
    }

    @Override // com.baidu.live.e.c
    public void ze() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.buq);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501008, hashMap));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void zH() {
        super.zH();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }
}
