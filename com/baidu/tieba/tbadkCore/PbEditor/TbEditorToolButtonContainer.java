package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class TbEditorToolButtonContainer extends m {
    protected TextView Zs;
    protected TextView Zu;
    protected EditorToolButton bWV;
    protected EditorToolButton bWW;
    protected EditorToolButton bWX;
    protected EditorToolButton bWY;
    protected TextView bWZ;
    protected EditorToolButton bWt;
    protected TextView bWv;
    protected Context mContext;

    public TbEditorToolButtonContainer(Context context) {
        super(context);
        this.mContext = context;
        initialize();
    }

    public TbEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initialize();
    }

    public TbEditorToolButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initialize();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bWt != null && this.bWt.getTip() != null) {
            int intrinsicWidth = this.bWt.getDrawable().getIntrinsicWidth();
            int intrinsicHeight = this.bWt.getDrawable().getIntrinsicHeight();
            TextView tip = this.bWt.getTip();
            int right = (this.bWt.getRight() - ((this.bWt.getMeasuredWidth() - intrinsicWidth) / 2)) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 9.0f);
            int measuredHeight = (((this.bWt.getMeasuredHeight() - intrinsicHeight) / 2) + this.bWt.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 4.0f);
            tip.layout(right, measuredHeight, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + measuredHeight);
        }
        if (this.bWX != null && this.bWX.getTip() != null) {
            int intrinsicWidth2 = this.bWX.getDrawable().getIntrinsicWidth();
            int intrinsicHeight2 = this.bWX.getDrawable().getIntrinsicHeight();
            TextView tip2 = this.bWX.getTip();
            int right2 = (this.bWX.getRight() - ((this.bWX.getMeasuredWidth() - intrinsicWidth2) / 2)) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 9.0f);
            int measuredHeight2 = (((this.bWX.getMeasuredHeight() - intrinsicHeight2) / 2) + this.bWX.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 4.0f);
            tip2.layout(right2, measuredHeight2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + measuredHeight2);
        }
        if (this.bWW != null && this.bWW.getTip() != null) {
            int intrinsicWidth3 = this.bWW.getDrawable().getIntrinsicWidth();
            int intrinsicHeight3 = this.bWW.getDrawable().getIntrinsicHeight();
            int measuredWidth = (this.bWW.getMeasuredWidth() - intrinsicWidth3) / 2;
            int measuredHeight3 = (this.bWW.getMeasuredHeight() - intrinsicHeight3) / 2;
            TextView tip3 = this.bWW.getTip();
            if (TextUtils.isEmpty(tip3.getText())) {
                int right3 = (this.bWW.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 7.0f);
                int top = (measuredHeight3 + this.bWW.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 0.0f);
                tip3.layout(right3, top, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top);
                return;
            }
            int right4 = (this.bWW.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 7.0f);
            int top2 = (measuredHeight3 + this.bWW.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 7.0f);
            tip3.layout(right4, top2, tip3.getMeasuredWidth() + right4, tip3.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        ZY();
        this.bWV = (EditorToolButton) findViewById(com.baidu.tieba.w.select_face);
        this.bWY = (EditorToolButton) findViewById(com.baidu.tieba.w.select_at);
        this.bWX = (EditorToolButton) findViewById(com.baidu.tieba.w.select_privilege);
        this.bWW = (EditorToolButton) findViewById(com.baidu.tieba.w.select_picture);
        this.bWt = (EditorToolButton) findViewById(com.baidu.tieba.w.select_more);
        this.bWt.tQ();
        setDrawTop(false);
    }

    protected void ZY() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.write_editor_tool_button_container, this, true);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.bWV.setOnClickListener(a);
            this.bWY.setOnClickListener(a);
            this.bWW.setOnClickListener(a);
            this.bWX.setOnClickListener(a);
            this.bWt.setOnClickListener(a);
        }
    }

    public void agz() {
        afr();
        this.bWV.afn();
    }

    public void agA() {
        afr();
        this.bWW.afn();
    }

    public void agB() {
        afr();
        this.bWX.afn();
    }

    public void agC() {
    }

    public void agD() {
        afr();
    }

    public void agE() {
        afr();
        this.bWt.afn();
    }

    public void agF() {
    }

    public void setFaceFocusable(boolean z) {
        this.bWV.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.bWY.setFocusable(z);
    }

    public void setPrivilegeFocusable(boolean z) {
        this.bWX.setFocusable(z);
    }

    public void setBaobaoFocusable(boolean z) {
    }

    public void setFaceEnabled(boolean z) {
        this.bWV.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.bWY.setEnabled(z);
    }

    public void setBaobaoEnabled(boolean z) {
    }

    public void setPrivilegeEnable(boolean z) {
        this.bWX.setEnabled(z);
    }

    public void setBaobaoEnable(boolean z) {
    }

    public void eb(String str) {
        if (this.bWZ == null) {
            this.bWZ = a(this.bWW, true);
        } else {
            b(this.bWW, true);
        }
        this.bWW.ig(str);
    }

    public void vt() {
    }

    public void vu() {
        this.bWX.tQ();
    }

    public void agG() {
    }

    public void vr() {
        if (this.bWW != null) {
            b(this.bWW, true);
            this.bWW.tQ();
        }
    }

    public void agp() {
        this.bWt.tQ();
    }

    public void ago() {
        if (this.bWv == null) {
            this.bWv = a(this.bWt, false);
        }
        this.bWt.tP();
    }

    public void ez(boolean z) {
        if (z) {
            this.bWX.yL();
        } else {
            this.bWX.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.Zs != null) {
            bc.i((View) this.Zs, com.baidu.tieba.v.icon_news_head_prompt_one);
        }
        if (this.Zu != null) {
            bc.i((View) this.Zu, com.baidu.tieba.v.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.bWV) {
            wVar.handleAction(1, null);
        } else if (editorToolButton == this.bWY) {
            wVar.handleAction(0, null);
        } else if (editorToolButton == this.bWW) {
            wVar.handleAction(55, null);
        } else if (editorToolButton == this.bWX) {
            wVar.handleAction(43, null);
        } else if (editorToolButton == this.bWt) {
            wVar.handleAction(37, null);
        }
        if (editorToolButton.afm()) {
            if (editorToolButton.isFocused()) {
                afr();
                if (editorToolButton == this.bWV) {
                    wVar.handleAction(3, null);
                } else if (editorToolButton == this.bWY) {
                    wVar.handleAction(16, null);
                } else if (editorToolButton == this.bWW) {
                    wVar.handleAction(56, null);
                } else if (editorToolButton == this.bWX) {
                    wVar.handleAction(45, null);
                } else if (editorToolButton == this.bWt) {
                    wVar.handleAction(39, null);
                }
            } else if (editorToolButton == this.bWV) {
                wVar.handleAction(2, null);
            } else if (editorToolButton == this.bWY) {
                wVar.handleAction(17, null);
            } else if (editorToolButton == this.bWW) {
                wVar.handleAction(57, null);
            } else if (editorToolButton == this.bWt) {
                wVar.handleAction(38, null);
            } else if (editorToolButton == this.bWX) {
                wVar.handleAction(44, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new ax(this, wVar);
    }
}
