package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends m {
    protected EditorToolButton bWs;
    protected EditorToolButton bWt;
    protected TextView bWu;
    protected TextView bWv;
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

    protected void ZY() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.pb_editor_tool_button_container, this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bWs.getTip() != null) {
            TextView tip = this.bWs.getTip();
            int right = this.bWs.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
            int top = this.bWs.getTop() + com.baidu.adp.lib.util.l.dip2px(this.mContext, 1.0f);
            this.bWs.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.bWt.getTip() != null) {
            TextView tip2 = this.bWt.getTip();
            int right2 = this.bWt.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
            int top2 = this.bWt.getTop() + com.baidu.adp.lib.util.l.dip2px(this.mContext, 1.0f);
            this.bWt.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        setDrawTop(false);
        ZY();
        this.bWt = (EditorToolButton) findViewById(com.baidu.tieba.w.tool_more);
        this.bWs = (EditorToolButton) findViewById(com.baidu.tieba.w.tool_audio);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.bWt.setOnClickListener(a);
            this.bWs.setOnClickListener(a);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.bWt.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.bWs.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.bWt.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.bWs.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.bWs.setHardDisabled(z);
    }

    public void agm() {
        if (this.bWu == null) {
            this.bWu = a(this.bWs, false);
        }
        this.bWs.tP();
    }

    public void agn() {
        this.bWs.tQ();
    }

    public void ago() {
        if (this.bWv == null) {
            this.bWv = a(this.bWt, false);
        }
        this.bWt.tP();
    }

    public void agp() {
        this.bWt.tQ();
    }

    public void ey(boolean z) {
        if (z) {
            this.bWs.yL();
        } else {
            this.bWs.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.bWu != null) {
            bc.i((View) this.bWu, com.baidu.tieba.v.icon_news_down_bar_one);
        }
        if (this.bWv != null) {
            bc.i((View) this.bWv, com.baidu.tieba.v.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.bWt) {
            wVar.handleAction(37, null);
        } else if (editorToolButton == this.bWs) {
            wVar.handleAction(4, null);
        }
        if (editorToolButton.afm() && !editorToolButton.isFocused()) {
            afr();
            editorToolButton.afn();
            if (editorToolButton == this.bWt) {
                wVar.handleAction(38, null);
            } else if (editorToolButton == this.bWs) {
                wVar.handleAction(5, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new af(this, wVar);
    }
}
