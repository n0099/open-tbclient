package com.baidu.tieba.memberCenter.tail.edit.color;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class d extends m {
    public d(TbPageContext<?> tbPageContext, int i, String str) {
        super(tbPageContext.getPageActivity(), TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title), 17, i);
        this.fDA = R.drawable.tail_edit_tool_color_selector;
        this.fDC = R.drawable.icon_pure_post_more_bubble64;
        this.fCN = new TailEditColorToolHost(tbPageContext, str);
        this.fDI = true;
        this.fDH = 6;
        this.fDJ = new int[]{1};
    }
}
