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
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes8.dex */
public class b {
    private ViewGroup bcD;
    private EditText cCD;
    private EditorTools fCC;
    private ImageView luD;
    private TextView luE;
    private ImageView luF;
    private FrameLayout luG;
    private BaseActivity<?> mActivity;
    private ProgressBar mProgressBar;
    private Window mWindow;

    public EditText getEditText() {
        return this.cCD;
    }

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mActivity = baseActivity;
        this.mWindow = baseActivity.getWindow();
        this.bcD = (ViewGroup) this.mWindow.findViewById(R.id.tail_edit_root);
        this.cCD = (EditText) this.mWindow.findViewById(R.id.tail_edit_edittext);
        this.luD = (ImageView) this.mWindow.findViewById(R.id.tail_edit_submit);
        this.luD.setOnClickListener(onClickListener);
        this.luF = (ImageView) this.mWindow.findViewById(R.id.tail_edit_cancel);
        this.luF.setOnClickListener(onClickListener2);
        this.luE = (TextView) this.mWindow.findViewById(R.id.tail_edit_text_number);
        this.luG = (FrameLayout) this.mWindow.findViewById(R.id.tail_edit_editor);
        this.mProgressBar = (ProgressBar) this.mWindow.findViewById(R.id.tail_edit_progress);
    }

    public void b(EditorTools editorTools) {
        this.luG.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
    }

    public void dgl() {
        if (this.cCD.getSelectionStart() > 0) {
            String substring = this.cCD.getText().toString().substring(0, this.cCD.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            int i = 1;
            if (matcher.find()) {
                i = substring.length() - matcher.replaceFirst("").length();
            }
            this.cCD.getText().delete(this.cCD.getSelectionStart() - i, this.cCD.getSelectionStart());
        }
    }

    public void cU(int i, int i2) {
        this.luE.setText(i + "/" + i2);
        int i3 = R.color.CAM_X0109;
        if (i == i2) {
            i3 = R.color.CAM_X0301;
        }
        ap.setViewTextColor(this.luE, i3, 1);
    }

    public void setContent(String str) {
        this.cCD.setText(TbFaceManager.bCR().a(this.mActivity.getPageContext().getPageActivity(), str, null));
    }

    public void setColor(String str) {
        this.cCD.setTextColor(c.Ov(str));
    }

    public String getContent() {
        return this.cCD.getText().toString();
    }

    public void dgm() {
        this.mActivity.ShowSoftKeyPadDelay(this.cCD);
        this.cCD.setSelection(this.cCD.length());
    }

    public void dgn() {
        this.cCD.setSelection(this.cCD.length());
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.bcD);
        this.fCC.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.editortools.b bVar, String str) {
        this.fCC = new EditorTools(this.mActivity.getPageContext().getPageActivity());
        dgo();
        a(bVar);
        b(bVar, str);
        this.fCC.build();
        this.fCC.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        this.fCC.display();
        b(this.fCC);
    }

    private void dgo() {
        this.fCC.setBarMaxLauCount(4);
        this.fCC.setBarLauncherType(1);
        this.fCC.kN(true);
        this.fCC.setBackgroundColorId(R.color.CAM_X0201);
    }

    private void b(com.baidu.tbadk.editortools.b bVar, String str) {
        this.fCC.b(new d(this.mActivity.getPageContext(), 2, str));
        this.fCC.setActionListener(26, bVar);
        this.fCC.setActionListener(3, bVar);
    }

    private void a(com.baidu.tbadk.editortools.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fCC.bG(arrayList);
        m qV = this.fCC.qV(5);
        if (qV != null) {
            qV.fDG = 1;
            qV.kQ(false);
        }
        this.fCC.setActionListener(24, bVar);
    }

    public void bzG() {
        this.fCC.bzG();
        this.fCC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
    }

    public void a(TailData tailData) {
        if (tailData != null) {
            setContent(tailData.getContent());
            setColor(tailData.getFontColor());
        }
    }

    public void tV(boolean z) {
        this.luD.setEnabled(z);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
