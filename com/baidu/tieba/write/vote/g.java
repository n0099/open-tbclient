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
    private WriteVoteActivity dnc;
    private ImageView dng;
    private EditText dnh;
    private ImageView dni;
    private ImageFileInfo dnj;
    private LayoutInflater dnk;
    private b dnl;
    private View.OnClickListener mClickListener;
    private int mId;
    private View mRootView;
    private int mType;

    public g(WriteVoteActivity writeVoteActivity, int i) {
        super(writeVoteActivity.getPageContext());
        this.mType = 1;
        this.mClickListener = new h(this);
        this.dnc = writeVoteActivity;
        this.mType = i;
        this.dnl = writeVoteActivity;
        this.mId = BdUniqueId.gen().getId();
        this.dnk = LayoutInflater.from(getActivity());
        initView();
    }

    private void initView() {
        if (this.mType == 0) {
            this.mRootView = this.dnk.inflate(i.g.vote_pic_item, (ViewGroup) null);
            this.dng = (ImageView) this.mRootView.findViewById(i.f.item_pic);
        } else {
            this.mRootView = this.dnk.inflate(i.g.vote_text_item, (ViewGroup) null);
            this.dng = (ImageView) this.mRootView.findViewById(i.f.item_icon);
        }
        this.dnh = (EditText) this.mRootView.findViewById(i.f.item_edittext);
        this.dni = (ImageView) this.mRootView.findViewById(i.f.item_delete);
        this.dng.setOnClickListener(this.mClickListener);
        this.dni.setOnClickListener(this.mClickListener);
        if (this.mType == 0) {
            this.dnh.addTextChangedListener(new a(10, this.dnh));
        } else {
            this.dnh.addTextChangedListener(new a(15, this.dnh));
        }
        aCv();
    }

    public boolean aCq() {
        return (this.dnj == null || TextUtils.isEmpty(this.dnj.getFilePath())) ? false : true;
    }

    public boolean aCr() {
        return !TextUtils.isEmpty(aCs());
    }

    public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        if (this.mType == 0) {
            this.dnj = imageFileInfo;
            if (aVar != null) {
                aVar.a(this.dng);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public int getId() {
        return this.mId;
    }

    public String aCs() {
        return this.dnh == null ? "" : this.dnh.getText().toString().trim();
    }

    public void ma(int i) {
        if (this.dnh != null) {
            this.dnh.setText("");
            this.dnh.setHint(i);
            this.dnh.requestFocus();
        }
    }

    public void aCt() {
        if (this.dnh != null) {
            this.dnh.requestFocus();
        }
    }

    public ImageFileInfo aCu() {
        return this.dnj;
    }

    public void aCv() {
        if (this.mRootView != null) {
            com.baidu.tbadk.h.a.a(this.dnc.getPageContext(), this.mRootView);
        }
    }

    private Activity getActivity() {
        return this.dnc.getPageContext().getPageActivity();
    }
}
