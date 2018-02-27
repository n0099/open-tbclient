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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<WriteVoteActivity> {
    private WriteVoteActivity hIG;
    private ImageView hIJ;
    private EditText hIK;
    private ImageView hIL;
    private ImageFileInfo hIM;
    private LayoutInflater hIN;
    private b hIO;
    private View.OnClickListener mClickListener;
    private int mId;
    private View mRootView;
    private int mType;

    public d(WriteVoteActivity writeVoteActivity, int i) {
        super(writeVoteActivity.getPageContext());
        this.mType = 1;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != d.this.hIJ) {
                    if (view == d.this.hIL) {
                        d.this.hIO.xB(d.this.mId);
                    }
                } else if (d.this.bHy()) {
                    d.this.hIO.am(d.this.mId, d.this.hIM.getFilePath());
                } else {
                    d.this.hIO.xA(d.this.mId);
                }
            }
        };
        this.hIG = writeVoteActivity;
        this.mType = i;
        this.hIO = writeVoteActivity;
        this.mId = BdUniqueId.gen().getId();
        this.hIN = LayoutInflater.from(getActivity());
        initView();
    }

    private void initView() {
        if (this.mType == 0) {
            this.mRootView = this.hIN.inflate(d.h.vote_pic_item, (ViewGroup) null);
            this.hIJ = (ImageView) this.mRootView.findViewById(d.g.item_pic);
        } else {
            this.mRootView = this.hIN.inflate(d.h.vote_text_item, (ViewGroup) null);
            this.hIJ = (ImageView) this.mRootView.findViewById(d.g.item_icon);
        }
        this.hIK = (EditText) this.mRootView.findViewById(d.g.item_edittext);
        this.hIL = (ImageView) this.mRootView.findViewById(d.g.item_delete);
        this.hIJ.setOnClickListener(this.mClickListener);
        this.hIL.setOnClickListener(this.mClickListener);
        if (this.mType == 0) {
            this.hIK.addTextChangedListener(new a(10, this.hIK));
        } else {
            this.hIK.addTextChangedListener(new a(15, this.hIK));
        }
        bHD();
    }

    public boolean bHy() {
        return (this.hIM == null || TextUtils.isEmpty(this.hIM.getFilePath())) ? false : true;
    }

    public boolean bHz() {
        return !TextUtils.isEmpty(bHA());
    }

    public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        if (this.mType == 0) {
            this.hIM = imageFileInfo;
            if (aVar != null) {
                aVar.a(this.hIJ);
                this.hIJ.setContentDescription(getActivity().getString(d.j.look_big_photo));
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public int getId() {
        return this.mId;
    }

    public String bHA() {
        return this.hIK == null ? "" : this.hIK.getText().toString().trim();
    }

    public void setEditText(String str) {
        if (this.hIK != null) {
            this.hIK.setText(str);
        }
    }

    public void xE(int i) {
        if (this.hIK != null) {
            this.hIK.setText("");
            this.hIK.setHint(i);
            this.hIK.requestFocus();
        }
    }

    public void bHB() {
        if (this.hIK != null) {
            this.hIK.requestFocus();
        }
    }

    public ImageFileInfo bHC() {
        return this.hIM;
    }

    public void bHD() {
        if (this.mRootView != null) {
            com.baidu.tbadk.n.a.a(this.hIG.getPageContext(), this.mRootView);
        }
    }

    private Activity getActivity() {
        return this.hIG.getPageContext().getPageActivity();
    }
}
