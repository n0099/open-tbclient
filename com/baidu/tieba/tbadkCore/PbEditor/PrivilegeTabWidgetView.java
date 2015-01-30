package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PrivilegeTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortool.w Yj;
    private PrivilegeTabHorizonScrollView bWT;
    private ImageView bWU;

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
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.privilege_tab_widget, this, true);
        this.bWT = (PrivilegeTabHorizonScrollView) findViewById(com.baidu.tieba.w.privilege_tab_scroll_view);
        this.bWU = (ImageView) findViewById(com.baidu.tieba.w.privilege_tab_delete);
        this.bWU.setOnClickListener(new av(this));
    }

    public void setDatas(ArrayList<ao> arrayList) {
        this.bWT.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(aq aqVar) {
        this.bWT.c(aqVar);
    }

    public void setCurrentTab(int i) {
        this.bWT.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(aw awVar) {
        this.bWT.setOnTabSelectedListener(awVar);
    }

    public void reset() {
        this.bWT.reset();
    }

    public void onChangeSkinType(int i) {
        bc.j(this, com.baidu.tieba.t.editor_tool_container_bg);
        getContext().getResources();
        this.bWT.ct(i);
        bc.c(this.bWU, com.baidu.tieba.v.but_face_close);
        bc.j(this.bWU, com.baidu.tieba.t.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bWU.setVisibility(0);
        } else {
            this.bWU.setVisibility(8);
        }
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        this.Yj = wVar;
    }
}
