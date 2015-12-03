package com.baidu.tieba.write.vote;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.f<WriteVoteActivity> {
    private ImageView dOA;
    private ImageFileInfo dOB;
    private LayoutInflater dOC;
    private b dOD;
    private WriteVoteActivity dOu;
    private ImageView dOy;
    private EditText dOz;
    private View.OnClickListener mClickListener;
    private int mId;
    private View mRootView;
    private int mType;

    public g(WriteVoteActivity writeVoteActivity, int i) {
        super(writeVoteActivity.getPageContext());
        this.mType = 1;
        this.mClickListener = new h(this);
        this.dOu = writeVoteActivity;
        this.mType = i;
        this.dOD = writeVoteActivity;
        this.mId = BdUniqueId.gen().getId();
        this.dOC = LayoutInflater.from(getActivity());
        initView();
    }

    private void initView() {
        if (this.mType == 0) {
            this.mRootView = this.dOC.inflate(n.g.vote_pic_item, (ViewGroup) null);
            this.dOy = (ImageView) this.mRootView.findViewById(n.f.item_pic);
        } else {
            this.mRootView = this.dOC.inflate(n.g.vote_text_item, (ViewGroup) null);
            this.dOy = (ImageView) this.mRootView.findViewById(n.f.item_icon);
        }
        this.dOz = (EditText) this.mRootView.findViewById(n.f.item_edittext);
        this.dOA = (ImageView) this.mRootView.findViewById(n.f.item_delete);
        this.dOy.setOnClickListener(this.mClickListener);
        this.dOA.setOnClickListener(this.mClickListener);
        if (this.mType == 0) {
            this.dOz.addTextChangedListener(new a(10, this.dOz));
        } else {
            this.dOz.addTextChangedListener(new a(15, this.dOz));
        }
        aIQ();
    }

    public boolean aIL() {
        return (this.dOB == null || TextUtils.isEmpty(this.dOB.getFilePath())) ? false : true;
    }

    public boolean aIM() {
        return !TextUtils.isEmpty(aIN());
    }

    public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        if (this.mType == 0) {
            this.dOB = imageFileInfo;
            if (aVar != null) {
                aVar.a(this.dOy);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public int getId() {
        return this.mId;
    }

    public String aIN() {
        return this.dOz == null ? "" : this.dOz.getText().toString().trim();
    }

    public void nC(int i) {
        if (this.dOz != null) {
            this.dOz.setText("");
            this.dOz.setHint(i);
            this.dOz.requestFocus();
        }
    }

    public void aIO() {
        if (this.dOz != null) {
            this.dOz.requestFocus();
        }
    }

    public ImageFileInfo aIP() {
        return this.dOB;
    }

    public void aIQ() {
        if (this.mRootView != null) {
            com.baidu.tbadk.i.a.a(this.dOu.getPageContext(), this.mRootView);
        }
    }

    private Activity getActivity() {
        return this.dOu.getPageContext().getPageActivity();
    }
}
