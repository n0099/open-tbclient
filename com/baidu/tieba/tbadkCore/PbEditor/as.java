package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class as extends LinearLayout implements aw {
    private int Yk;
    private ArrayList<ao> amP;
    private au bWK;
    private PrivilegeTabContentView bWQ;
    private PrivilegeTabWidgetView bWR;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    public as(Context context) {
        super(context);
        this.amP = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.Yk = -1;
        this.bWK = new at(this);
        init(context);
    }

    private void agC() {
        this.amP.clear();
        this.amP.add(new b(this.bWK));
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.privilege_tab_host, this, true);
        this.bWQ = (PrivilegeTabContentView) findViewById(com.baidu.tieba.w.privilege_tab_content);
        this.bWR = (PrivilegeTabWidgetView) findViewById(com.baidu.tieba.w.privilege_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.privilege_progress);
        this.bWR.setOnTabSelectedListener(this);
        setOrientation(1);
        this.Yk = TbadkCoreApplication.m255getInst().getSkinType();
        onChangeSkinType(this.Yk);
        setup();
    }

    private void setup() {
        agC();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType != this.Yk) {
            this.Yk = skinType;
            onChangeSkinType(this.Yk);
        }
        if (i != 8 && i != 4) {
            Iterator<ao> it = this.amP.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar) {
        this.bWR.c(aqVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.amP.size()) {
            this.bWQ.a(this.amP.get(i));
            this.bWR.setShowDelete(true);
            this.bWR.setCurrentTab(i);
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
        this.bWR.onChangeSkinType(i);
        this.bWQ.onChangeSkinType(i);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        Iterator<ao> it = this.amP.iterator();
        while (it.hasNext()) {
            it.next().b(wVar);
        }
        this.bWQ.setOnDataSelected(wVar);
        this.bWR.setOnDataSelected(wVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<ao> it = this.amP.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }
}
