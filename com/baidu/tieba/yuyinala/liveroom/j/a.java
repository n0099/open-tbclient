package com.baidu.tieba.yuyinala.liveroom.j;

import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.c;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.tieba.yuyinala.liveroom.introduce.d;
import com.baidu.tieba.yuyinala.liveroom.roomcard.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a implements c {
    private w bqS;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void Y(w wVar) {
        this.bqS = wVar;
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("listener", this);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501015, hashMap));
    }

    @Override // com.baidu.live.c.c
    public void CF() {
        new f(getPageContext().getPageActivity()).Z(this.bqS);
    }

    @Override // com.baidu.live.c.c
    public void CG() {
        if (this.bqS != null && this.bqS.aJK != null) {
            new d(getPageContext().getPageActivity()).X(this.bqS);
        }
    }

    @Override // com.baidu.live.c.c
    public void CH() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bqS);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501007, hashMap));
    }

    @Override // com.baidu.live.c.c
    public void CI() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bqS);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501006, hashMap));
    }

    @Override // com.baidu.live.c.c
    public void CJ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("context", getPageContext());
        hashMap.put("ala_live_show_data", this.bqS);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501008, hashMap));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        super.ax(viewGroup);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Dm() {
        super.Dm();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }
}
