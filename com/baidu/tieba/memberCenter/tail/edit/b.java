package com.baidu.tieba.memberCenter.tail.edit;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.a.c;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.edit.color.d;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class b {
    private ViewGroup bcK;
    private EditText cDt;
    private EditorTools fDw;
    private ImageView loQ;
    private TextView loR;
    private ImageView loS;
    private FrameLayout loT;
    private BaseActivity<?> mActivity;
    private ProgressBar mProgressBar;
    private Window mWindow;

    public EditText getEditText() {
        return this.cDt;
    }

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mActivity = baseActivity;
        this.mWindow = baseActivity.getWindow();
        this.bcK = (ViewGroup) this.mWindow.findViewById(R.id.tail_edit_root);
        this.cDt = (EditText) this.mWindow.findViewById(R.id.tail_edit_edittext);
        this.loQ = (ImageView) this.mWindow.findViewById(R.id.tail_edit_submit);
        this.loQ.setOnClickListener(onClickListener);
        this.loS = (ImageView) this.mWindow.findViewById(R.id.tail_edit_cancel);
        this.loS.setOnClickListener(onClickListener2);
        this.loR = (TextView) this.mWindow.findViewById(R.id.tail_edit_text_number);
        this.loT = (FrameLayout) this.mWindow.findViewById(R.id.tail_edit_editor);
        this.mProgressBar = (ProgressBar) this.mWindow.findViewById(R.id.tail_edit_progress);
    }

    public void b(EditorTools editorTools) {
        this.loT.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
    }

    public void dhN() {
        if (this.cDt.getSelectionStart() > 0) {
            String substring = this.cDt.getText().toString().substring(0, this.cDt.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            int i = 1;
            if (matcher.find()) {
                i = substring.length() - matcher.replaceFirst("").length();
            }
            this.cDt.getText().delete(this.cDt.getSelectionStart() - i, this.cDt.getSelectionStart());
        }
    }

    public void cW(int i, int i2) {
        this.loR.setText(i + "/" + i2);
        int i3 = R.color.CAM_X0109;
        if (i == i2) {
            i3 = R.color.CAM_X0301;
        }
        ao.setViewTextColor(this.loR, i3, 1);
    }

    public void setContent(String str) {
        this.cDt.setText(TbFaceManager.bGp().a(this.mActivity.getPageContext().getPageActivity(), str, null));
    }

    public void setColor(String str) {
        this.cDt.setTextColor(c.OH(str));
    }

    public String getContent() {
        return this.cDt.getText().toString();
    }

    public void dhO() {
        this.mActivity.ShowSoftKeyPadDelay(this.cDt);
        this.cDt.setSelection(this.cDt.length());
    }

    public void dhP() {
        this.cDt.setSelection(this.cDt.length());
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.bcK);
        this.fDw.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.editortools.b bVar, String str) {
        this.fDw = new EditorTools(this.mActivity.getPageContext().getPageActivity());
        dhQ();
        a(bVar);
        b(bVar, str);
        this.fDw.build();
        this.fDw.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        this.fDw.rV();
        b(this.fDw);
    }

    private void dhQ() {
        this.fDw.setBarMaxLauCount(4);
        this.fDw.setBarLauncherType(1);
        this.fDw.kO(true);
        this.fDw.setBackgroundColorId(R.color.CAM_X0201);
    }

    private void b(com.baidu.tbadk.editortools.b bVar, String str) {
        this.fDw.b(new d(this.mActivity.getPageContext(), 2, str));
        this.fDw.setActionListener(26, bVar);
        this.fDw.setActionListener(3, bVar);
    }

    private void a(com.baidu.tbadk.editortools.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fDw.bL(arrayList);
        m sv = this.fDw.sv(5);
        if (sv != null) {
            sv.fEA = 1;
            sv.kR(false);
        }
        this.fDw.setActionListener(24, bVar);
    }

    public void bDf() {
        this.fDw.bDf();
        this.fDw.b(new com.baidu.tbadk.editortools.a(5, -1, null));
    }

    public void a(TailData tailData) {
        if (tailData != null) {
            setContent(tailData.getContent());
            setColor(tailData.getFontColor());
        }
    }

    public void tM(boolean z) {
        this.loQ.setEnabled(z);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
