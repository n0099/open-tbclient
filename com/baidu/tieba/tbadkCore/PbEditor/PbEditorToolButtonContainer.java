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
    protected EditorToolButton cmZ;
    protected EditorToolButton cna;
    protected TextView cnb;
    protected TextView cnc;
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

    protected void acx() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.pb_editor_tool_button_container, this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.cmZ.getTip() != null) {
            TextView tip = this.cmZ.getTip();
            int right = this.cmZ.getRight() - com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f);
            int top = this.cmZ.getTop() + com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f);
            this.cmZ.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.cna.getTip() != null) {
            TextView tip2 = this.cna.getTip();
            int right2 = this.cna.getRight() - com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f);
            int top2 = this.cna.getTop() + com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f);
            this.cna.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        setDrawTop(false);
        acx();
        this.cna = (EditorToolButton) findViewById(com.baidu.tieba.v.tool_more);
        this.cmZ = (EditorToolButton) findViewById(com.baidu.tieba.v.tool_audio);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001298, com.baidu.tieba.tbadkCore.l.a.class);
        if (runTask != null && runTask.getData() != null) {
            ba.c(this.cmZ, ((com.baidu.tieba.tbadkCore.l.a) runTask.getData()).nV());
        }
        if (!com.baidu.tieba.tbadkCore.voice.d.anO()) {
            this.cmZ.hide();
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            View.OnClickListener b = b(vVar);
            this.cna.setOnClickListener(b);
            this.cmZ.setOnClickListener(b);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.cna.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.cmZ.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.cna.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.cmZ.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.cmZ.setHardDisabled(z);
    }

    public void amp() {
        if (this.cnb == null) {
            this.cnb = a(this.cmZ, false);
        }
        this.cmZ.displayTip();
    }

    public void amq() {
        this.cmZ.hideTip();
    }

    public void amr() {
        if (this.cnc == null) {
            this.cnc = a(this.cna, false);
        }
        this.cna.displayTip();
    }

    public void ams() {
        this.cna.hideTip();
    }

    public void eL(boolean z) {
        if (z && com.baidu.tieba.tbadkCore.voice.d.anO()) {
            this.cmZ.Cf();
        } else {
            this.cmZ.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.cnb != null) {
            ba.i((View) this.cnb, com.baidu.tieba.u.icon_news_down_bar_one);
        }
        if (this.cnc != null) {
            ba.i((View) this.cnc, com.baidu.tieba.u.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.v vVar) {
        if (editorToolButton == this.cna) {
            vVar.handleAction(37, null);
        } else if (editorToolButton == this.cmZ) {
            vVar.handleAction(4, null);
        }
        if (editorToolButton.alo()) {
            if (!editorToolButton.isFocused()) {
                alt();
                editorToolButton.alp();
                if (editorToolButton == this.cna) {
                    vVar.handleAction(38, null);
                } else if (editorToolButton == this.cmZ) {
                    vVar.handleAction(5, null);
                }
            } else if (editorToolButton == this.cna) {
                alt();
                editorToolButton.alp();
                vVar.handleAction(64, null);
            }
        }
    }

    protected View.OnClickListener b(com.baidu.tbadk.editortool.v vVar) {
        return new w(this, vVar);
    }
}
