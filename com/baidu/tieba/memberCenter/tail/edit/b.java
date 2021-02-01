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
/* loaded from: classes9.dex */
public class b {
    private ViewGroup bbd;
    private EditText cBd;
    private EditorTools fBd;
    private ImageView lsm;
    private TextView lsn;
    private ImageView lso;
    private FrameLayout lsp;
    private BaseActivity<?> mActivity;
    private ProgressBar mProgressBar;
    private Window mWindow;

    public EditText getEditText() {
        return this.cBd;
    }

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mActivity = baseActivity;
        this.mWindow = baseActivity.getWindow();
        this.bbd = (ViewGroup) this.mWindow.findViewById(R.id.tail_edit_root);
        this.cBd = (EditText) this.mWindow.findViewById(R.id.tail_edit_edittext);
        this.lsm = (ImageView) this.mWindow.findViewById(R.id.tail_edit_submit);
        this.lsm.setOnClickListener(onClickListener);
        this.lso = (ImageView) this.mWindow.findViewById(R.id.tail_edit_cancel);
        this.lso.setOnClickListener(onClickListener2);
        this.lsn = (TextView) this.mWindow.findViewById(R.id.tail_edit_text_number);
        this.lsp = (FrameLayout) this.mWindow.findViewById(R.id.tail_edit_editor);
        this.mProgressBar = (ProgressBar) this.mWindow.findViewById(R.id.tail_edit_progress);
    }

    public void b(EditorTools editorTools) {
        this.lsp.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
    }

    public void dfV() {
        if (this.cBd.getSelectionStart() > 0) {
            String substring = this.cBd.getText().toString().substring(0, this.cBd.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            int i = 1;
            if (matcher.find()) {
                i = substring.length() - matcher.replaceFirst("").length();
            }
            this.cBd.getText().delete(this.cBd.getSelectionStart() - i, this.cBd.getSelectionStart());
        }
    }

    public void cT(int i, int i2) {
        this.lsn.setText(i + "/" + i2);
        int i3 = R.color.CAM_X0109;
        if (i == i2) {
            i3 = R.color.CAM_X0301;
        }
        ap.setViewTextColor(this.lsn, i3, 1);
    }

    public void setContent(String str) {
        this.cBd.setText(TbFaceManager.bCO().a(this.mActivity.getPageContext().getPageActivity(), str, null));
    }

    public void setColor(String str) {
        this.cBd.setTextColor(c.Oo(str));
    }

    public String getContent() {
        return this.cBd.getText().toString();
    }

    public void dfW() {
        this.mActivity.ShowSoftKeyPadDelay(this.cBd);
        this.cBd.setSelection(this.cBd.length());
    }

    public void dfX() {
        this.cBd.setSelection(this.cBd.length());
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.bbd);
        this.fBd.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.editortools.b bVar, String str) {
        this.fBd = new EditorTools(this.mActivity.getPageContext().getPageActivity());
        dfY();
        a(bVar);
        b(bVar, str);
        this.fBd.build();
        this.fBd.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        this.fBd.display();
        b(this.fBd);
    }

    private void dfY() {
        this.fBd.setBarMaxLauCount(4);
        this.fBd.setBarLauncherType(1);
        this.fBd.kN(true);
        this.fBd.setBackgroundColorId(R.color.CAM_X0201);
    }

    private void b(com.baidu.tbadk.editortools.b bVar, String str) {
        this.fBd.b(new d(this.mActivity.getPageContext(), 2, str));
        this.fBd.setActionListener(26, bVar);
        this.fBd.setActionListener(3, bVar);
    }

    private void a(com.baidu.tbadk.editortools.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fBd.bG(arrayList);
        m qU = this.fBd.qU(5);
        if (qU != null) {
            qU.fCh = 1;
            qU.kQ(false);
        }
        this.fBd.setActionListener(24, bVar);
    }

    public void bzD() {
        this.fBd.bzD();
        this.fBd.b(new com.baidu.tbadk.editortools.a(5, -1, null));
    }

    public void a(TailData tailData) {
        if (tailData != null) {
            setContent(tailData.getContent());
            setColor(tailData.getFontColor());
        }
    }

    public void tV(boolean z) {
        this.lsm.setEnabled(z);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
