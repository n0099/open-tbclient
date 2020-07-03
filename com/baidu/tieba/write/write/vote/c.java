package com.baidu.tieba.write.write.vote;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends RecyclerView.Adapter {
    private List<WriteVoteItemData> mData;
    private TbPageContext mPageContext;
    private InterfaceC0780c mxz;
    private boolean mxy = false;
    TextView.OnEditorActionListener mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.write.write.vote.c.1
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            View focusSearch;
            if (i == 5 && (focusSearch = textView.focusSearch(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER)) != null) {
                focusSearch.requestFocus(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                return true;
            }
            return true;
        }
    };

    /* renamed from: com.baidu.tieba.write.write.vote.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0780c {
        void Ha(int i);

        void a(WriteVoteItemData writeVoteItemData, int i);

        void duz();
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<WriteVoteItemData> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0780c interfaceC0780c) {
        this.mxz = interfaceC0780c;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new b(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_item, viewGroup, false));
        }
        return new a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_add_item, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            String text = this.mData.get(i).getText();
            bVar.mxE.setHint(String.format(this.mPageContext.getString(R.string.write_vote_item), Integer.valueOf(i + 1)));
            bVar.mxE.setGravity(19);
            if (i < this.mData.size() - 1) {
                bVar.mxE.setImeOptions(5);
            } else {
                bVar.mxE.setImeOptions(1);
            }
            ImageView imageView = bVar.mxF;
            if (this.mData.size() > 2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mxz != null) {
                        c.this.mxz.Ha(i);
                    }
                }
            });
            bVar.setPosition(i);
            if (!StringUtils.isNull(text)) {
                bVar.mxE.setText(text);
            } else {
                bVar.mxE.setText("");
            }
            if (this.mxy && i == this.mData.size() - 1) {
                bVar.mxE.requestFocus();
                this.mxy = false;
            }
        } else if (viewHolder instanceof a) {
            a aVar = (a) viewHolder;
            aVar.mxB.setText(String.format(this.mPageContext.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.mData.size())));
            aVar.mxD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mxz != null) {
                        c.this.mxz.duz();
                        c.this.mxy = true;
                    }
                }
            });
        }
        d(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return !Hb(i) ? 1 : 2;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mData == null) {
            return 0;
        }
        if (this.mData.size() < 20) {
            return this.mData.size() + 1;
        }
        return 20;
    }

    public void d(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.mPageContext.getResources().getDimension(R.dimen.tbds10));
            gradientDrawable.setColor(an.getColor(R.color.cp_bg_line_j));
            gradientDrawable.setStroke(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_border_d), 0.16f));
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                bVar.mxE.setTextColor(an.getColor(R.color.cp_cont_b));
                bVar.mxE.setHintTextColor(an.getColor(R.color.cp_cont_d));
                bVar.mxE.setBackgroundDrawable(gradientDrawable);
                SvgManager.aWQ().a(bVar.mxF, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else if (viewHolder instanceof a) {
                a aVar = (a) viewHolder;
                an.setViewTextColor(aVar.mxB, (int) R.color.cp_link_tip_a);
                aVar.mxD.setBackgroundDrawable(gradientDrawable);
                SvgManager.aWQ().a(aVar.mxC, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }

    private boolean Hb(int i) {
        return this.mData != null && this.mData.size() < 20 && i == this.mData.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ViewHolder {
        public EditText mxE;
        public ImageView mxF;
        private d mxG;

        public b(View view) {
            super(view);
            this.mxE = (EditText) view.findViewById(R.id.vote_item);
            this.mxF = (ImageView) view.findViewById(R.id.img_delete);
            this.mxG = new d(this);
            this.mxE.setOnEditorActionListener(c.this.mOnEditorActionListener);
        }

        public void setPosition(int i) {
            this.mxG.setPosition(i);
            this.mxE.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.vote.c.b.1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        b.this.mxE.addTextChangedListener(b.this.mxG);
                    } else {
                        b.this.mxE.removeTextChangedListener(b.this.mxG);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView mxB;
        public ImageView mxC;
        public RelativeLayout mxD;

        public a(View view) {
            super(view);
            this.mxB = (TextView) view.findViewById(R.id.vote_add_item);
            this.mxC = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.mxD = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements TextWatcher {
        private final b mxI;
        private int position;

        public d(b bVar) {
            this.mxI = bVar;
        }

        public void setPosition(int i) {
            this.position = i;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable != null) {
                String obj = editable.toString();
                if (!StringUtils.isNull(obj)) {
                    WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                    writeVoteItemData.setId(this.position + 1);
                    if (ae.getTextLengthWithEmoji(obj) > 28) {
                        obj = ae.subStringWithEmoji(obj, 28);
                        this.mxI.mxE.setText(obj);
                        this.mxI.mxE.setSelection(obj.length());
                        c.this.mPageContext.showToast(String.format(c.this.mPageContext.getString(R.string.write_vote_toast), 14));
                    }
                    writeVoteItemData.setText(obj);
                    c.this.mxz.a(writeVoteItemData, this.position);
                }
            }
        }
    }
}
