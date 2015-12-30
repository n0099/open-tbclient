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
    private WriteVoteActivity dVT;
    private ImageView dVX;
    private EditText dVY;
    private ImageView dVZ;
    private ImageFileInfo dWa;
    private LayoutInflater dWb;
    private b dWc;
    private View.OnClickListener mClickListener;
    private int mId;
    private View mRootView;
    private int mType;

    public g(WriteVoteActivity writeVoteActivity, int i) {
        super(writeVoteActivity.getPageContext());
        this.mType = 1;
        this.mClickListener = new h(this);
        this.dVT = writeVoteActivity;
        this.mType = i;
        this.dWc = writeVoteActivity;
        this.mId = BdUniqueId.gen().getId();
        this.dWb = LayoutInflater.from(getActivity());
        initView();
    }

    private void initView() {
        if (this.mType == 0) {
            this.mRootView = this.dWb.inflate(n.h.vote_pic_item, (ViewGroup) null);
            this.dVX = (ImageView) this.mRootView.findViewById(n.g.item_pic);
        } else {
            this.mRootView = this.dWb.inflate(n.h.vote_text_item, (ViewGroup) null);
            this.dVX = (ImageView) this.mRootView.findViewById(n.g.item_icon);
        }
        this.dVY = (EditText) this.mRootView.findViewById(n.g.item_edittext);
        this.dVZ = (ImageView) this.mRootView.findViewById(n.g.item_delete);
        this.dVX.setOnClickListener(this.mClickListener);
        this.dVZ.setOnClickListener(this.mClickListener);
        if (this.mType == 0) {
            this.dVY.addTextChangedListener(new a(10, this.dVY));
        } else {
            this.dVY.addTextChangedListener(new a(15, this.dVY));
        }
        aLl();
    }

    public boolean aLg() {
        return (this.dWa == null || TextUtils.isEmpty(this.dWa.getFilePath())) ? false : true;
    }

    public boolean aLh() {
        return !TextUtils.isEmpty(aLi());
    }

    public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        if (this.mType == 0) {
            this.dWa = imageFileInfo;
            if (aVar != null) {
                aVar.a(this.dVX);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public int getId() {
        return this.mId;
    }

    public String aLi() {
        return this.dVY == null ? "" : this.dVY.getText().toString().trim();
    }

    public void ou(int i) {
        if (this.dVY != null) {
            this.dVY.setText("");
            this.dVY.setHint(i);
            this.dVY.requestFocus();
        }
    }

    public void aLj() {
        if (this.dVY != null) {
            this.dVY.requestFocus();
        }
    }

    public ImageFileInfo aLk() {
        return this.dWa;
    }

    public void aLl() {
        if (this.mRootView != null) {
            com.baidu.tbadk.i.a.a(this.dVT.getPageContext(), this.mRootView);
        }
    }

    private Activity getActivity() {
        return this.dVT.getPageContext().getPageActivity();
    }
}
