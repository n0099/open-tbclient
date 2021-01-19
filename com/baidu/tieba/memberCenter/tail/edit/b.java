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
/* loaded from: classes8.dex */
public class b {
    private ViewGroup aXW;
    private EditText cyH;
    private EditorTools fyO;
    private ImageView lkg;
    private TextView lkh;
    private ImageView lki;
    private FrameLayout lkj;
    private BaseActivity<?> mActivity;
    private ProgressBar mProgressBar;
    private Window mWindow;

    public EditText getEditText() {
        return this.cyH;
    }

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mActivity = baseActivity;
        this.mWindow = baseActivity.getWindow();
        this.aXW = (ViewGroup) this.mWindow.findViewById(R.id.tail_edit_root);
        this.cyH = (EditText) this.mWindow.findViewById(R.id.tail_edit_edittext);
        this.lkg = (ImageView) this.mWindow.findViewById(R.id.tail_edit_submit);
        this.lkg.setOnClickListener(onClickListener);
        this.lki = (ImageView) this.mWindow.findViewById(R.id.tail_edit_cancel);
        this.lki.setOnClickListener(onClickListener2);
        this.lkh = (TextView) this.mWindow.findViewById(R.id.tail_edit_text_number);
        this.lkj = (FrameLayout) this.mWindow.findViewById(R.id.tail_edit_editor);
        this.mProgressBar = (ProgressBar) this.mWindow.findViewById(R.id.tail_edit_progress);
    }

    public void b(EditorTools editorTools) {
        this.lkj.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
    }

    public void ddV() {
        if (this.cyH.getSelectionStart() > 0) {
            String substring = this.cyH.getText().toString().substring(0, this.cyH.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            int i = 1;
            if (matcher.find()) {
                i = substring.length() - matcher.replaceFirst("").length();
            }
            this.cyH.getText().delete(this.cyH.getSelectionStart() - i, this.cyH.getSelectionStart());
        }
    }

    public void cW(int i, int i2) {
        this.lkh.setText(i + "/" + i2);
        int i3 = R.color.CAM_X0109;
        if (i == i2) {
            i3 = R.color.CAM_X0301;
        }
        ao.setViewTextColor(this.lkh, i3, 1);
    }

    public void setContent(String str) {
        this.cyH.setText(TbFaceManager.bCw().a(this.mActivity.getPageContext().getPageActivity(), str, null));
    }

    public void setColor(String str) {
        this.cyH.setTextColor(c.NA(str));
    }

    public String getContent() {
        return this.cyH.getText().toString();
    }

    public void ddW() {
        this.mActivity.ShowSoftKeyPadDelay(this.cyH);
        this.cyH.setSelection(this.cyH.length());
    }

    public void ddX() {
        this.cyH.setSelection(this.cyH.length());
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.aXW);
        this.fyO.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.editortools.b bVar, String str) {
        this.fyO = new EditorTools(this.mActivity.getPageContext().getPageActivity());
        ddY();
        a(bVar);
        b(bVar, str);
        this.fyO.build();
        this.fyO.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        this.fyO.rV();
        b(this.fyO);
    }

    private void ddY() {
        this.fyO.setBarMaxLauCount(4);
        this.fyO.setBarLauncherType(1);
        this.fyO.kK(true);
        this.fyO.setBackgroundColorId(R.color.CAM_X0201);
    }

    private void b(com.baidu.tbadk.editortools.b bVar, String str) {
        this.fyO.b(new d(this.mActivity.getPageContext(), 2, str));
        this.fyO.setActionListener(26, bVar);
        this.fyO.setActionListener(3, bVar);
    }

    private void a(com.baidu.tbadk.editortools.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fyO.bL(arrayList);
        m qP = this.fyO.qP(5);
        if (qP != null) {
            qP.fzS = 1;
            qP.kN(false);
        }
        this.fyO.setActionListener(24, bVar);
    }

    public void bzl() {
        this.fyO.bzl();
        this.fyO.b(new com.baidu.tbadk.editortools.a(5, -1, null));
    }

    public void a(TailData tailData) {
        if (tailData != null) {
            setContent(tailData.getContent());
            setColor(tailData.getFontColor());
        }
    }

    public void tI(boolean z) {
        this.lkg.setEnabled(z);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
