package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class as extends LinearLayout implements aw {
    private int XE;
    private au bUR;
    private PrivilegeTabContentView bUX;
    private PrivilegeTabWidgetView bUY;
    private Context mContext;
    private int mCurrentIndex;
    private ArrayList<ao> mData;
    private ProgressBar mProgressBar;

    public as(Context context) {
        super(context);
        this.mData = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.XE = -1;
        this.bUR = new at(this);
        init(context);
    }

    private void afY() {
        this.mData.clear();
        this.mData.add(new b(this.bUR));
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.x.privilege_tab_host, this, true);
        this.bUX = (PrivilegeTabContentView) findViewById(com.baidu.tieba.w.privilege_tab_content);
        this.bUY = (PrivilegeTabWidgetView) findViewById(com.baidu.tieba.w.privilege_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.privilege_progress);
        this.bUY.setOnTabSelectedListener(this);
        setOrientation(1);
        this.XE = TbadkCoreApplication.m255getInst().getSkinType();
        onChangeSkinType(this.XE);
        setup();
    }

    private void setup() {
        afY();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType != this.XE) {
            this.XE = skinType;
            onChangeSkinType(this.XE);
        }
        if (i != 8 && i != 4) {
            Iterator<ao> it = this.mData.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar) {
        this.bUY.c(aqVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.mData.size()) {
            this.bUX.a(this.mData.get(i));
            this.bUY.setShowDelete(true);
            this.bUY.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.aw
    public void df(int i) {
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
        this.bUY.onChangeSkinType(i);
        this.bUX.onChangeSkinType(i);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        Iterator<ao> it = this.mData.iterator();
        while (it.hasNext()) {
            it.next().b(wVar);
        }
        this.bUX.setOnDataSelected(wVar);
        this.bUY.setOnDataSelected(wVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<ao> it = this.mData.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }
}
