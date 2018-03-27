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
    private WriteVoteActivity hJe;
    private ImageView hJh;
    private EditText hJi;
    private ImageView hJj;
    private ImageFileInfo hJk;
    private LayoutInflater hJl;
    private b hJm;
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
                if (view != d.this.hJh) {
                    if (view == d.this.hJj) {
                        d.this.hJm.xB(d.this.mId);
                    }
                } else if (d.this.bHD()) {
                    d.this.hJm.am(d.this.mId, d.this.hJk.getFilePath());
                } else {
                    d.this.hJm.xA(d.this.mId);
                }
            }
        };
        this.hJe = writeVoteActivity;
        this.mType = i;
        this.hJm = writeVoteActivity;
        this.mId = BdUniqueId.gen().getId();
        this.hJl = LayoutInflater.from(getActivity());
        initView();
    }

    private void initView() {
        if (this.mType == 0) {
            this.mRootView = this.hJl.inflate(d.h.vote_pic_item, (ViewGroup) null);
            this.hJh = (ImageView) this.mRootView.findViewById(d.g.item_pic);
        } else {
            this.mRootView = this.hJl.inflate(d.h.vote_text_item, (ViewGroup) null);
            this.hJh = (ImageView) this.mRootView.findViewById(d.g.item_icon);
        }
        this.hJi = (EditText) this.mRootView.findViewById(d.g.item_edittext);
        this.hJj = (ImageView) this.mRootView.findViewById(d.g.item_delete);
        this.hJh.setOnClickListener(this.mClickListener);
        this.hJj.setOnClickListener(this.mClickListener);
        if (this.mType == 0) {
            this.hJi.addTextChangedListener(new a(10, this.hJi));
        } else {
            this.hJi.addTextChangedListener(new a(15, this.hJi));
        }
        bHI();
    }

    public boolean bHD() {
        return (this.hJk == null || TextUtils.isEmpty(this.hJk.getFilePath())) ? false : true;
    }

    public boolean bHE() {
        return !TextUtils.isEmpty(bHF());
    }

    public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        if (this.mType == 0) {
            this.hJk = imageFileInfo;
            if (aVar != null) {
                aVar.a(this.hJh);
                this.hJh.setContentDescription(getActivity().getString(d.j.look_big_photo));
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public int getId() {
        return this.mId;
    }

    public String bHF() {
        return this.hJi == null ? "" : this.hJi.getText().toString().trim();
    }

    public void setEditText(String str) {
        if (this.hJi != null) {
            this.hJi.setText(str);
        }
    }

    public void xE(int i) {
        if (this.hJi != null) {
            this.hJi.setText("");
            this.hJi.setHint(i);
            this.hJi.requestFocus();
        }
    }

    public void bHG() {
        if (this.hJi != null) {
            this.hJi.requestFocus();
        }
    }

    public ImageFileInfo bHH() {
        return this.hJk;
    }

    public void bHI() {
        if (this.mRootView != null) {
            com.baidu.tbadk.n.a.a(this.hJe.getPageContext(), this.mRootView);
        }
    }

    private Activity getActivity() {
        return this.hJe.getPageContext().getPageActivity();
    }
}
