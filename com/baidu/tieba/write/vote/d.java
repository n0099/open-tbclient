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
    private WriteVoteActivity hIT;
    private ImageView hIW;
    private EditText hIX;
    private ImageView hIY;
    private ImageFileInfo hIZ;
    private LayoutInflater hJa;
    private b hJb;
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
                if (view != d.this.hIW) {
                    if (view == d.this.hIY) {
                        d.this.hJb.xA(d.this.mId);
                    }
                } else if (d.this.bHz()) {
                    d.this.hJb.am(d.this.mId, d.this.hIZ.getFilePath());
                } else {
                    d.this.hJb.xz(d.this.mId);
                }
            }
        };
        this.hIT = writeVoteActivity;
        this.mType = i;
        this.hJb = writeVoteActivity;
        this.mId = BdUniqueId.gen().getId();
        this.hJa = LayoutInflater.from(getActivity());
        initView();
    }

    private void initView() {
        if (this.mType == 0) {
            this.mRootView = this.hJa.inflate(d.h.vote_pic_item, (ViewGroup) null);
            this.hIW = (ImageView) this.mRootView.findViewById(d.g.item_pic);
        } else {
            this.mRootView = this.hJa.inflate(d.h.vote_text_item, (ViewGroup) null);
            this.hIW = (ImageView) this.mRootView.findViewById(d.g.item_icon);
        }
        this.hIX = (EditText) this.mRootView.findViewById(d.g.item_edittext);
        this.hIY = (ImageView) this.mRootView.findViewById(d.g.item_delete);
        this.hIW.setOnClickListener(this.mClickListener);
        this.hIY.setOnClickListener(this.mClickListener);
        if (this.mType == 0) {
            this.hIX.addTextChangedListener(new a(10, this.hIX));
        } else {
            this.hIX.addTextChangedListener(new a(15, this.hIX));
        }
        bHE();
    }

    public boolean bHz() {
        return (this.hIZ == null || TextUtils.isEmpty(this.hIZ.getFilePath())) ? false : true;
    }

    public boolean bHA() {
        return !TextUtils.isEmpty(bHB());
    }

    public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        if (this.mType == 0) {
            this.hIZ = imageFileInfo;
            if (aVar != null) {
                aVar.a(this.hIW);
                this.hIW.setContentDescription(getActivity().getString(d.j.look_big_photo));
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public int getId() {
        return this.mId;
    }

    public String bHB() {
        return this.hIX == null ? "" : this.hIX.getText().toString().trim();
    }

    public void setEditText(String str) {
        if (this.hIX != null) {
            this.hIX.setText(str);
        }
    }

    public void xD(int i) {
        if (this.hIX != null) {
            this.hIX.setText("");
            this.hIX.setHint(i);
            this.hIX.requestFocus();
        }
    }

    public void bHC() {
        if (this.hIX != null) {
            this.hIX.requestFocus();
        }
    }

    public ImageFileInfo bHD() {
        return this.hIZ;
    }

    public void bHE() {
        if (this.mRootView != null) {
            com.baidu.tbadk.n.a.a(this.hIT.getPageContext(), this.mRootView);
        }
    }

    private Activity getActivity() {
        return this.hIT.getPageContext().getPageActivity();
    }
}
