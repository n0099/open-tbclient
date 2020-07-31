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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends RecyclerView.Adapter {
    private List<WriteVoteItemData> mData;
    private InterfaceC0791c mFH;
    private TbPageContext mPageContext;
    private boolean mFG = false;
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
    /* loaded from: classes3.dex */
    public interface InterfaceC0791c {
        void Hv(int i);

        void a(WriteVoteItemData writeVoteItemData, int i);

        void dxP();
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<WriteVoteItemData> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0791c interfaceC0791c) {
        this.mFH = interfaceC0791c;
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
            bVar.mFM.setHint(String.format(this.mPageContext.getString(R.string.write_vote_item), Integer.valueOf(i + 1)));
            bVar.mFM.setGravity(19);
            if (i < this.mData.size() - 1) {
                bVar.mFM.setImeOptions(5);
            } else {
                bVar.mFM.setImeOptions(1);
            }
            ImageView imageView = bVar.mFN;
            if (this.mData.size() > 2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mFH != null) {
                        c.this.mFH.Hv(i);
                    }
                }
            });
            bVar.setPosition(i);
            if (!StringUtils.isNull(text)) {
                bVar.mFM.setText(text);
            } else {
                bVar.mFM.setText("");
            }
            if (this.mFG && i == this.mData.size() - 1) {
                bVar.mFM.requestFocus();
                this.mFG = false;
            }
        } else if (viewHolder instanceof a) {
            a aVar = (a) viewHolder;
            aVar.mFJ.setText(String.format(this.mPageContext.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.mData.size())));
            aVar.mFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mFH != null) {
                        c.this.mFH.dxP();
                        c.this.mFG = true;
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
        return !Hw(i) ? 1 : 2;
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
            gradientDrawable.setColor(ao.getColor(R.color.cp_bg_line_j));
            gradientDrawable.setStroke(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_border_d), 0.16f));
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                bVar.mFM.setTextColor(ao.getColor(R.color.cp_cont_b));
                bVar.mFM.setHintTextColor(ao.getColor(R.color.cp_cont_d));
                bVar.mFM.setBackgroundDrawable(gradientDrawable);
                SvgManager.baR().a(bVar.mFN, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else if (viewHolder instanceof a) {
                a aVar = (a) viewHolder;
                ao.setViewTextColor(aVar.mFJ, R.color.cp_link_tip_a);
                aVar.mFL.setBackgroundDrawable(gradientDrawable);
                SvgManager.baR().a(aVar.mFK, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }

    private boolean Hw(int i) {
        return this.mData != null && this.mData.size() < 20 && i == this.mData.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends RecyclerView.ViewHolder {
        public EditText mFM;
        public ImageView mFN;
        private d mFO;

        public b(View view) {
            super(view);
            this.mFM = (EditText) view.findViewById(R.id.vote_item);
            this.mFN = (ImageView) view.findViewById(R.id.img_delete);
            this.mFO = new d(this);
            this.mFM.setOnEditorActionListener(c.this.mOnEditorActionListener);
        }

        public void setPosition(int i) {
            this.mFO.setPosition(i);
            this.mFM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.vote.c.b.1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        b.this.mFM.addTextChangedListener(b.this.mFO);
                    } else {
                        b.this.mFM.removeTextChangedListener(b.this.mFO);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView mFJ;
        public ImageView mFK;
        public RelativeLayout mFL;

        public a(View view) {
            super(view);
            this.mFJ = (TextView) view.findViewById(R.id.vote_add_item);
            this.mFK = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.mFL = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d implements TextWatcher {
        private final b mFQ;
        private int position;

        public d(b bVar) {
            this.mFQ = bVar;
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
                        this.mFQ.mFM.setText(obj);
                        this.mFQ.mFM.setSelection(obj.length());
                        c.this.mPageContext.showToast(String.format(c.this.mPageContext.getString(R.string.write_vote_toast), 14));
                    }
                    writeVoteItemData.setText(obj);
                    c.this.mFH.a(writeVoteItemData, this.position);
                }
            }
        }
    }
}
