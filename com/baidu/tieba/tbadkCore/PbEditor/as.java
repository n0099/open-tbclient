package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class as extends LinearLayout implements aw {
    private int Yh;
    private ArrayList<ao> amM;
    private au bWJ;
    private PrivilegeTabContentView bWP;
    private PrivilegeTabWidgetView bWQ;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    public as(Context context) {
        super(context);
        this.amM = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.Yh = -1;
        this.bWJ = new at(this);
        init(context);
    }

    private void agx() {
        this.amM.clear();
        this.amM.add(new b(this.bWJ));
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.privilege_tab_host, this, true);
        this.bWP = (PrivilegeTabContentView) findViewById(com.baidu.tieba.w.privilege_tab_content);
        this.bWQ = (PrivilegeTabWidgetView) findViewById(com.baidu.tieba.w.privilege_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.privilege_progress);
        this.bWQ.setOnTabSelectedListener(this);
        setOrientation(1);
        this.Yh = TbadkCoreApplication.m255getInst().getSkinType();
        onChangeSkinType(this.Yh);
        setup();
    }

    private void setup() {
        agx();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType != this.Yh) {
            this.Yh = skinType;
            onChangeSkinType(this.Yh);
        }
        if (i != 8 && i != 4) {
            Iterator<ao> it = this.amM.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar) {
        this.bWQ.c(aqVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.amM.size()) {
            this.bWP.a(this.amM.get(i));
            this.bWQ.setShowDelete(true);
            this.bWQ.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.aw
    public void dm(int i) {
        setCurrentTab(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.bWQ.onChangeSkinType(i);
        this.bWP.onChangeSkinType(i);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        Iterator<ao> it = this.amM.iterator();
        while (it.hasNext()) {
            it.next().b(wVar);
        }
        this.bWP.setOnDataSelected(wVar);
        this.bWQ.setOnDataSelected(wVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<ao> it = this.amM.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }
}
