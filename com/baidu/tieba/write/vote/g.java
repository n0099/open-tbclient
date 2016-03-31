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
    private View.OnClickListener OZ;
    private ImageFileInfo bKH;
    private WriteVoteActivity eKG;
    private ImageView eKK;
    private EditText eKL;
    private ImageView eKM;
    private LayoutInflater eKN;
    private b eKO;
    private int mId;
    private View mRootView;
    private int mType;

    public g(WriteVoteActivity writeVoteActivity, int i) {
        super(writeVoteActivity.getPageContext());
        this.mType = 1;
        this.OZ = new h(this);
        this.eKG = writeVoteActivity;
        this.mType = i;
        this.eKO = writeVoteActivity;
        this.mId = BdUniqueId.gen().getId();
        this.eKN = LayoutInflater.from(getActivity());
        initView();
    }

    private void initView() {
        if (this.mType == 0) {
            this.mRootView = this.eKN.inflate(t.h.vote_pic_item, (ViewGroup) null);
            this.eKK = (ImageView) this.mRootView.findViewById(t.g.item_pic);
        } else {
            this.mRootView = this.eKN.inflate(t.h.vote_text_item, (ViewGroup) null);
            this.eKK = (ImageView) this.mRootView.findViewById(t.g.item_icon);
        }
        this.eKL = (EditText) this.mRootView.findViewById(t.g.item_edittext);
        this.eKM = (ImageView) this.mRootView.findViewById(t.g.item_delete);
        this.eKK.setOnClickListener(this.OZ);
        this.eKM.setOnClickListener(this.OZ);
        if (this.mType == 0) {
            this.eKL.addTextChangedListener(new a(10, this.eKL));
        } else {
            this.eKL.addTextChangedListener(new a(15, this.eKL));
        }
        baF();
    }

    public boolean baB() {
        return (this.bKH == null || TextUtils.isEmpty(this.bKH.getFilePath())) ? false : true;
    }

    public boolean baC() {
        return !TextUtils.isEmpty(baD());
    }

    public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        if (this.mType == 0) {
            this.bKH = imageFileInfo;
            if (aVar != null) {
                aVar.a(this.eKK);
                this.eKK.setContentDescription(getActivity().getString(t.j.look_big_photo));
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public int getId() {
        return this.mId;
    }

    public String baD() {
        return this.eKL == null ? "" : this.eKL.getText().toString().trim();
    }

    public void oU(String str) {
        if (this.eKL != null) {
            this.eKL.setText(str);
        }
    }

    public void qJ(int i) {
        if (this.eKL != null) {
            this.eKL.setText("");
            this.eKL.setHint(i);
            this.eKL.requestFocus();
        }
    }

    public void baE() {
        if (this.eKL != null) {
            this.eKL.requestFocus();
        }
    }

    public ImageFileInfo Yp() {
        return this.bKH;
    }

    public void baF() {
        if (this.mRootView != null) {
            com.baidu.tbadk.i.a.a(this.eKG.getPageContext(), this.mRootView);
        }
    }

    private Activity getActivity() {
        return this.eKG.getPageContext().getPageActivity();
    }
}
