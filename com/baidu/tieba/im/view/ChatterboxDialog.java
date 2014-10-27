package com.baidu.tieba.im.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.tieba.im.data.ChatRoomTopicData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ChatterboxDialog extends Dialog implements View.OnClickListener {
    private static final int MAX_COUNT = 4;
    private ChatterboxEditDialog mChatterboxEditDialog;
    private List<b> mCollection;
    private Context mContext;
    private Button mCustomButton;
    private LinearLayout mLayout;
    private c mOnSelectedClickListener;
    private String mSelectedContent;
    private String mSelectedText;

    public void setSelectText(String str) {
        this.mSelectedText = str;
    }

    public void setSelectedContent(String str) {
        this.mSelectedContent = str;
    }

    public ChatterboxDialog(Context context) {
        super(context);
        this.mLayout = null;
        this.mCustomButton = null;
        this.mContext = null;
        this.mCollection = new ArrayList();
        this.mChatterboxEditDialog = null;
        this.mOnSelectedClickListener = null;
        this.mSelectedText = null;
        this.mSelectedContent = null;
        this.mContext = context;
        init();
    }

    public ChatterboxDialog(Context context, int i) {
        super(context, i);
        this.mLayout = null;
        this.mCustomButton = null;
        this.mContext = null;
        this.mCollection = new ArrayList();
        this.mChatterboxEditDialog = null;
        this.mOnSelectedClickListener = null;
        this.mSelectedText = null;
        this.mSelectedContent = null;
        this.mContext = context;
        init();
    }

    private void init() {
        setContentView(w.chatterbox_dialog);
        this.mSelectedText = this.mContext.getResources().getString(y.chat_default_tip);
        this.mSelectedContent = null;
        this.mCustomButton = (Button) findViewById(v.chatterbox_custom);
        this.mCustomButton.setOnClickListener(new a(this));
        this.mLayout = (LinearLayout) findViewById(v.chatterbox_layout);
        this.mChatterboxEditDialog = new ChatterboxEditDialog(this.mContext, z.NobackDialog);
    }

    public void setOnSelectedClickListener(c cVar) {
        this.mOnSelectedClickListener = cVar;
        this.mChatterboxEditDialog.setOnSelectedClickListener(cVar);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void setData(List<ChatRoomTopicData> list) {
        this.mLayout.removeAllViews();
        this.mCollection.clear();
        b bVar = new b(this, this.mContext);
        bVar.setText(this.mContext.getResources().getString(y.chat_default_tip));
        bVar.setOnClickListener(this);
        this.mCollection.add(bVar);
        this.mLayout.addView(bVar.getView());
        if (list != null) {
            int i = 0;
            Iterator<ChatRoomTopicData> it = list.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    ChatRoomTopicData next = it.next();
                    b bVar2 = new b(this, this.mContext);
                    bVar2.setText(next.getTitle());
                    bVar2.setContent(next.getContent());
                    bVar2.setOnClickListener(this);
                    this.mCollection.add(bVar2);
                    this.mLayout.addView(bVar2.getView());
                    i = i2 + 1;
                    if (i >= 4) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        if (!(this.mContext instanceof Activity) || com.baidu.adp.lib.g.j.e((Activity) this.mContext)) {
            super.show();
            if (TextUtils.isEmpty(this.mSelectedText)) {
                if (this.mCollection != null && this.mCollection.size() > 0) {
                    this.mCollection.get(0).setIsSelected(true);
                    for (int i = 1; i < this.mCollection.size(); i++) {
                        this.mCollection.get(i).setIsSelected(false);
                    }
                    return;
                }
                return;
            }
            for (b bVar : this.mCollection) {
                if (bVar.getText() != null && bVar.getText().equals(this.mSelectedText)) {
                    bVar.setIsSelected(true);
                } else {
                    bVar.setIsSelected(false);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (b bVar : this.mCollection) {
            if (bVar.M(view)) {
                bVar.setIsSelected(true);
                this.mSelectedText = bVar.getText();
                this.mSelectedContent = bVar.getContent();
                i = i3;
            } else {
                bVar.setIsSelected(false);
                i = i2;
            }
            i3++;
            i2 = i;
        }
        if (this.mOnSelectedClickListener != null) {
            this.mOnSelectedClickListener.f(this.mSelectedText, this.mSelectedContent, i2 == 0);
        }
        cancel();
    }
}
