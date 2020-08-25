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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends RecyclerView.Adapter {
    private List<WriteVoteItemData> mData;
    private TbPageContext mPageContext;
    private InterfaceC0844c mYI;
    private boolean mYH = false;
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
    public interface InterfaceC0844c {
        void JV(int i);

        void a(WriteVoteItemData writeVoteItemData, int i);

        void dJD();
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<WriteVoteItemData> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0844c interfaceC0844c) {
        this.mYI = interfaceC0844c;
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
            bVar.mYN.setHint(String.format(this.mPageContext.getString(R.string.write_vote_item), Integer.valueOf(i + 1)));
            bVar.mYN.setGravity(19);
            if (i < this.mData.size() - 1) {
                bVar.mYN.setImeOptions(5);
            } else {
                bVar.mYN.setImeOptions(1);
            }
            ImageView imageView = bVar.mYO;
            if (this.mData.size() > 2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mYI != null) {
                        c.this.mYI.JV(i);
                    }
                }
            });
            bVar.setPosition(i);
            if (!StringUtils.isNull(text)) {
                bVar.mYN.setText(text);
            } else {
                bVar.mYN.setText("");
            }
            if (this.mYH && i == this.mData.size() - 1) {
                bVar.mYN.requestFocus();
                this.mYH = false;
            }
        } else if (viewHolder instanceof a) {
            a aVar = (a) viewHolder;
            aVar.mYK.setText(String.format(this.mPageContext.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.mData.size())));
            aVar.mYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mYI != null) {
                        c.this.mYI.dJD();
                        c.this.mYH = true;
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
        return !JW(i) ? 1 : 2;
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
            gradientDrawable.setColor(ap.getColor(R.color.cp_bg_line_j));
            gradientDrawable.setStroke(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_border_d), 0.16f));
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                bVar.mYN.setTextColor(ap.getColor(R.color.cp_cont_b));
                bVar.mYN.setHintTextColor(ap.getColor(R.color.cp_cont_d));
                bVar.mYN.setBackgroundDrawable(gradientDrawable);
                SvgManager.bjq().a(bVar.mYO, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else if (viewHolder instanceof a) {
                a aVar = (a) viewHolder;
                ap.setViewTextColor(aVar.mYK, R.color.cp_link_tip_a);
                aVar.mYM.setBackgroundDrawable(gradientDrawable);
                SvgManager.bjq().a(aVar.mYL, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }

    private boolean JW(int i) {
        return this.mData != null && this.mData.size() < 20 && i == this.mData.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends RecyclerView.ViewHolder {
        public EditText mYN;
        public ImageView mYO;
        private d mYP;

        public b(View view) {
            super(view);
            this.mYN = (EditText) view.findViewById(R.id.vote_item);
            this.mYO = (ImageView) view.findViewById(R.id.img_delete);
            this.mYP = new d(this);
            this.mYN.setOnEditorActionListener(c.this.mOnEditorActionListener);
        }

        public void setPosition(int i) {
            this.mYP.setPosition(i);
            this.mYN.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.vote.c.b.1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        b.this.mYN.addTextChangedListener(b.this.mYP);
                    } else {
                        b.this.mYN.removeTextChangedListener(b.this.mYP);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView mYK;
        public ImageView mYL;
        public RelativeLayout mYM;

        public a(View view) {
            super(view);
            this.mYK = (TextView) view.findViewById(R.id.vote_add_item);
            this.mYL = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.mYM = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d implements TextWatcher {
        private final b mYR;
        private int position;

        public d(b bVar) {
            this.mYR = bVar;
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
                if (StringUtils.isNull(obj)) {
                    obj = "";
                }
                WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                writeVoteItemData.setId(this.position + 1);
                if (ae.getTextLengthWithEmoji(obj) > 28) {
                    obj = ae.subStringWithEmoji(obj, 28);
                    this.mYR.mYN.setText(obj);
                    this.mYR.mYN.setSelection(obj.length());
                    c.this.mPageContext.showToast(String.format(c.this.mPageContext.getString(R.string.write_vote_toast), 14));
                }
                writeVoteItemData.setText(obj);
                c.this.mYI.a(writeVoteItemData, this.position);
            }
        }
    }
}
