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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.f<WriteVoteActivity> {
    private View.OnClickListener OS;
    private WriteVoteActivity eqM;
    private ImageView eqQ;
    private EditText eqR;
    private ImageView eqS;
    private ImageFileInfo eqT;
    private LayoutInflater eqU;
    private b eqV;
    private int mId;
    private View mRootView;
    private int mType;

    public g(WriteVoteActivity writeVoteActivity, int i) {
        super(writeVoteActivity.getPageContext());
        this.mType = 1;
        this.OS = new h(this);
        this.eqM = writeVoteActivity;
        this.mType = i;
        this.eqV = writeVoteActivity;
        this.mId = BdUniqueId.gen().getId();
        this.eqU = LayoutInflater.from(getActivity());
        initView();
    }

    private void initView() {
        if (this.mType == 0) {
            this.mRootView = this.eqU.inflate(t.h.vote_pic_item, (ViewGroup) null);
            this.eqQ = (ImageView) this.mRootView.findViewById(t.g.item_pic);
        } else {
            this.mRootView = this.eqU.inflate(t.h.vote_text_item, (ViewGroup) null);
            this.eqQ = (ImageView) this.mRootView.findViewById(t.g.item_icon);
        }
        this.eqR = (EditText) this.mRootView.findViewById(t.g.item_edittext);
        this.eqS = (ImageView) this.mRootView.findViewById(t.g.item_delete);
        this.eqQ.setOnClickListener(this.OS);
        this.eqS.setOnClickListener(this.OS);
        if (this.mType == 0) {
            this.eqR.addTextChangedListener(new a(10, this.eqR));
        } else {
            this.eqR.addTextChangedListener(new a(15, this.eqR));
        }
        aUg();
    }

    public boolean aUb() {
        return (this.eqT == null || TextUtils.isEmpty(this.eqT.getFilePath())) ? false : true;
    }

    public boolean aUc() {
        return !TextUtils.isEmpty(aUd());
    }

    public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        if (this.mType == 0) {
            this.eqT = imageFileInfo;
            if (aVar != null) {
                aVar.a(this.eqQ);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public int getId() {
        return this.mId;
    }

    public String aUd() {
        return this.eqR == null ? "" : this.eqR.getText().toString().trim();
    }

    public void pP(int i) {
        if (this.eqR != null) {
            this.eqR.setText("");
            this.eqR.setHint(i);
            this.eqR.requestFocus();
        }
    }

    public void aUe() {
        if (this.eqR != null) {
            this.eqR.requestFocus();
        }
    }

    public ImageFileInfo aUf() {
        return this.eqT;
    }

    public void aUg() {
        if (this.mRootView != null) {
            com.baidu.tbadk.i.a.a(this.eqM.getPageContext(), this.mRootView);
        }
    }

    private Activity getActivity() {
        return this.eqM.getPageContext().getPageActivity();
    }
}
