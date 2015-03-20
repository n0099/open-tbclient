package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends c {
    protected EditorToolButton cmJ;
    protected EditorToolButton cmK;
    protected TextView cmL;
    protected TextView cmM;
    protected Context mContext;

    public PbEditorToolButtonContainer(Context context) {
        super(context);
        this.mContext = context;
        initialize();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initialize();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initialize();
    }

    protected void aci() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.pb_editor_tool_button_container, this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.cmJ.getTip() != null) {
            TextView tip = this.cmJ.getTip();
            int right = this.cmJ.getRight() - com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f);
            int top = this.cmJ.getTop() + com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f);
            this.cmJ.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.cmK.getTip() != null) {
            TextView tip2 = this.cmK.getTip();
            int right2 = this.cmK.getRight() - com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f);
            int top2 = this.cmK.getTop() + com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f);
            this.cmK.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        setDrawTop(false);
        aci();
        this.cmK = (EditorToolButton) findViewById(com.baidu.tieba.v.tool_more);
        this.cmJ = (EditorToolButton) findViewById(com.baidu.tieba.v.tool_audio);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001298, com.baidu.tieba.tbadkCore.l.a.class);
        if (runTask != null && runTask.getData() != null) {
            ba.c(this.cmJ, ((com.baidu.tieba.tbadkCore.l.a) runTask.getData()).nV());
        }
        if (!com.baidu.tieba.tbadkCore.voice.d.anz()) {
            this.cmJ.hide();
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            View.OnClickListener b = b(vVar);
            this.cmK.setOnClickListener(b);
            this.cmJ.setOnClickListener(b);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.cmK.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.cmJ.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.cmK.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.cmJ.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.cmJ.setHardDisabled(z);
    }

    public void ama() {
        if (this.cmL == null) {
            this.cmL = a(this.cmJ, false);
        }
        this.cmJ.displayTip();
    }

    public void amb() {
        this.cmJ.hideTip();
    }

    public void amc() {
        if (this.cmM == null) {
            this.cmM = a(this.cmK, false);
        }
        this.cmK.displayTip();
    }

    public void amd() {
        this.cmK.hideTip();
    }

    public void eN(boolean z) {
        if (z && com.baidu.tieba.tbadkCore.voice.d.anz()) {
            this.cmJ.BZ();
        } else {
            this.cmJ.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.cmL != null) {
            ba.i((View) this.cmL, com.baidu.tieba.u.icon_news_down_bar_one);
        }
        if (this.cmM != null) {
            ba.i((View) this.cmM, com.baidu.tieba.u.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.v vVar) {
        if (editorToolButton == this.cmK) {
            vVar.handleAction(37, null);
        } else if (editorToolButton == this.cmJ) {
            vVar.handleAction(4, null);
        }
        if (editorToolButton.akZ()) {
            if (!editorToolButton.isFocused()) {
                ale();
                editorToolButton.ala();
                if (editorToolButton == this.cmK) {
                    vVar.handleAction(38, null);
                } else if (editorToolButton == this.cmJ) {
                    vVar.handleAction(5, null);
                }
            } else if (editorToolButton == this.cmK) {
                ale();
                editorToolButton.ala();
                vVar.handleAction(64, null);
            }
        }
    }

    protected View.OnClickListener b(com.baidu.tbadk.editortool.v vVar) {
        return new w(this, vVar);
    }
}
