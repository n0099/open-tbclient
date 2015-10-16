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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.f<WriteVoteActivity> {
    private WriteVoteActivity dnC;
    private ImageView dnG;
    private EditText dnH;
    private ImageView dnI;
    private ImageFileInfo dnJ;
    private LayoutInflater dnK;
    private b dnL;
    private View.OnClickListener mClickListener;
    private int mId;
    private View mRootView;
    private int mType;

    public g(WriteVoteActivity writeVoteActivity, int i) {
        super(writeVoteActivity.getPageContext());
        this.mType = 1;
        this.mClickListener = new h(this);
        this.dnC = writeVoteActivity;
        this.mType = i;
        this.dnL = writeVoteActivity;
        this.mId = BdUniqueId.gen().getId();
        this.dnK = LayoutInflater.from(getActivity());
        initView();
    }

    private void initView() {
        if (this.mType == 0) {
            this.mRootView = this.dnK.inflate(i.g.vote_pic_item, (ViewGroup) null);
            this.dnG = (ImageView) this.mRootView.findViewById(i.f.item_pic);
        } else {
            this.mRootView = this.dnK.inflate(i.g.vote_text_item, (ViewGroup) null);
            this.dnG = (ImageView) this.mRootView.findViewById(i.f.item_icon);
        }
        this.dnH = (EditText) this.mRootView.findViewById(i.f.item_edittext);
        this.dnI = (ImageView) this.mRootView.findViewById(i.f.item_delete);
        this.dnG.setOnClickListener(this.mClickListener);
        this.dnI.setOnClickListener(this.mClickListener);
        if (this.mType == 0) {
            this.dnH.addTextChangedListener(new a(10, this.dnH));
        } else {
            this.dnH.addTextChangedListener(new a(15, this.dnH));
        }
        aCF();
    }

    public boolean aCA() {
        return (this.dnJ == null || TextUtils.isEmpty(this.dnJ.getFilePath())) ? false : true;
    }

    public boolean aCB() {
        return !TextUtils.isEmpty(aCC());
    }

    public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        if (this.mType == 0) {
            this.dnJ = imageFileInfo;
            if (aVar != null) {
                aVar.a(this.dnG);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public int getId() {
        return this.mId;
    }

    public String aCC() {
        return this.dnH == null ? "" : this.dnH.getText().toString().trim();
    }

    public void mc(int i) {
        if (this.dnH != null) {
            this.dnH.setText("");
            this.dnH.setHint(i);
            this.dnH.requestFocus();
        }
    }

    public void aCD() {
        if (this.dnH != null) {
            this.dnH.requestFocus();
        }
    }

    public ImageFileInfo aCE() {
        return this.dnJ;
    }

    public void aCF() {
        if (this.mRootView != null) {
            com.baidu.tbadk.h.a.a(this.dnC.getPageContext(), this.mRootView);
        }
    }

    private Activity getActivity() {
        return this.dnC.getPageContext().getPageActivity();
    }
}
