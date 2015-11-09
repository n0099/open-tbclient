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
    private b dpA;
    private WriteVoteActivity dpr;
    private ImageView dpv;
    private EditText dpw;
    private ImageView dpx;
    private ImageFileInfo dpy;
    private LayoutInflater dpz;
    private View.OnClickListener mClickListener;
    private int mId;
    private View mRootView;
    private int mType;

    public g(WriteVoteActivity writeVoteActivity, int i) {
        super(writeVoteActivity.getPageContext());
        this.mType = 1;
        this.mClickListener = new h(this);
        this.dpr = writeVoteActivity;
        this.mType = i;
        this.dpA = writeVoteActivity;
        this.mId = BdUniqueId.gen().getId();
        this.dpz = LayoutInflater.from(getActivity());
        initView();
    }

    private void initView() {
        if (this.mType == 0) {
            this.mRootView = this.dpz.inflate(i.g.vote_pic_item, (ViewGroup) null);
            this.dpv = (ImageView) this.mRootView.findViewById(i.f.item_pic);
        } else {
            this.mRootView = this.dpz.inflate(i.g.vote_text_item, (ViewGroup) null);
            this.dpv = (ImageView) this.mRootView.findViewById(i.f.item_icon);
        }
        this.dpw = (EditText) this.mRootView.findViewById(i.f.item_edittext);
        this.dpx = (ImageView) this.mRootView.findViewById(i.f.item_delete);
        this.dpv.setOnClickListener(this.mClickListener);
        this.dpx.setOnClickListener(this.mClickListener);
        if (this.mType == 0) {
            this.dpw.addTextChangedListener(new a(10, this.dpw));
        } else {
            this.dpw.addTextChangedListener(new a(15, this.dpw));
        }
        aDt();
    }

    public boolean aDo() {
        return (this.dpy == null || TextUtils.isEmpty(this.dpy.getFilePath())) ? false : true;
    }

    public boolean aDp() {
        return !TextUtils.isEmpty(aDq());
    }

    public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        if (this.mType == 0) {
            this.dpy = imageFileInfo;
            if (aVar != null) {
                aVar.a(this.dpv);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public int getId() {
        return this.mId;
    }

    public String aDq() {
        return this.dpw == null ? "" : this.dpw.getText().toString().trim();
    }

    public void mq(int i) {
        if (this.dpw != null) {
            this.dpw.setText("");
            this.dpw.setHint(i);
            this.dpw.requestFocus();
        }
    }

    public void aDr() {
        if (this.dpw != null) {
            this.dpw.requestFocus();
        }
    }

    public ImageFileInfo aDs() {
        return this.dpy;
    }

    public void aDt() {
        if (this.mRootView != null) {
            com.baidu.tbadk.h.a.a(this.dpr.getPageContext(), this.mRootView);
        }
    }

    private Activity getActivity() {
        return this.dpr.getPageContext().getPageActivity();
    }
}
