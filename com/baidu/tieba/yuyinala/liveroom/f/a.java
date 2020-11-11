package com.baidu.tieba.yuyinala.liveroom.f;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.bdswitchview.BdSwitchView;
import com.baidu.live.m.d;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private CustomMessageListener biW;
    private d hgl;
    private String hgm;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.biW = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.liveroom.f.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.hgm)) {
                    if (a.this.hgl == null) {
                        a.this.hgl = new d(a.this.getPageContext());
                    }
                    a.this.hgl.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.biW.setTag(tbPageContext.getUniqueId());
        this.biW.setSelfListener(true);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        super.ax(viewGroup);
        getPageContext().registerListener(this.biW);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Dm() {
        super.Dm();
        MessageManager.getInstance().unRegisterListener(this.biW);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void HV(String str) {
        this.hgm = str;
    }
}
