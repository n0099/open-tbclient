package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PrivilegeTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortool.w XD;
    private PrivilegeTabHorizonScrollView bVa;
    private ImageView bVb;

    public PrivilegeTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PrivilegeTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.x.privilege_tab_widget, this, true);
        this.bVa = (PrivilegeTabHorizonScrollView) findViewById(com.baidu.tieba.w.privilege_tab_scroll_view);
        this.bVb = (ImageView) findViewById(com.baidu.tieba.w.privilege_tab_delete);
        this.bVb.setOnClickListener(new av(this));
    }

    public void setDatas(ArrayList<ao> arrayList) {
        this.bVa.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(aq aqVar) {
        this.bVa.c(aqVar);
    }

    public void setCurrentTab(int i) {
        this.bVa.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(aw awVar) {
        this.bVa.setOnTabSelectedListener(awVar);
    }

    public void reset() {
        this.bVa.reset();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.ax.j(this, com.baidu.tieba.t.editor_tool_container_bg);
        getContext().getResources();
        this.bVa.cm(i);
        com.baidu.tbadk.core.util.ax.c(this.bVb, com.baidu.tieba.v.but_face_close);
        com.baidu.tbadk.core.util.ax.j(this.bVb, com.baidu.tieba.t.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bVb.setVisibility(0);
        } else {
            this.bVb.setVisibility(8);
        }
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        this.XD = wVar;
    }
}
