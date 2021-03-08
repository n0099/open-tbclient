package com.baidu.tieba.write.write.vote;

import android.graphics.drawable.GradientDrawable;
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
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class WriteVoteViewAdapter extends RecyclerView.Adapter {
    private List<WriteVoteItemData> mData;
    private TbPageContext mPageContext;
    private c oqR;
    private boolean oqQ = false;
    TextView.OnEditorActionListener mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.1
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

    /* loaded from: classes7.dex */
    public interface c {
        void LK(int i);

        void a(WriteVoteItemData writeVoteItemData, int i);

        void eao();
    }

    public WriteVoteViewAdapter(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<WriteVoteItemData> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void a(c cVar) {
        this.oqR = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new b(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_item, viewGroup, false));
        }
        return new a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_add_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            String text = this.mData.get(i).getText();
            bVar.oqW.setHint(String.format(this.mPageContext.getString(R.string.write_vote_item), Integer.valueOf(i + 1)));
            bVar.oqW.setGravity(19);
            if (i < this.mData.size() - 1) {
                bVar.oqW.setImeOptions(5);
            } else {
                bVar.oqW.setImeOptions(1);
            }
            ImageView imageView = bVar.oqX;
            if (this.mData.size() > 2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteVoteViewAdapter.this.oqR != null) {
                        WriteVoteViewAdapter.this.oqR.LK(i);
                    }
                }
            });
            bVar.setPosition(i);
            if (!StringUtils.isNull(text)) {
                bVar.oqW.setText(text);
            } else {
                bVar.oqW.setText("");
            }
            if (this.oqQ && i == this.mData.size() - 1) {
                bVar.oqW.requestFocus();
                this.oqQ = false;
            }
        } else if (viewHolder instanceof a) {
            a aVar = (a) viewHolder;
            aVar.oqT.setText(String.format(this.mPageContext.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.mData.size())));
            aVar.oqV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteVoteViewAdapter.this.oqR != null) {
                        WriteVoteViewAdapter.this.oqR.eao();
                        WriteVoteViewAdapter.this.oqQ = true;
                    }
                }
            });
        }
        d(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return !LL(i) ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
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
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0209));
            gradientDrawable.setStroke(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds1), ap.getColor(R.color.CAM_X0603));
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                bVar.oqW.setTextColor(ap.getColor(R.color.CAM_X0105));
                bVar.oqW.setHintTextColor(ap.getColor(R.color.CAM_X0109));
                bVar.oqW.setBackgroundDrawable(gradientDrawable);
                SvgManager.bsU().a(bVar.oqX, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else if (viewHolder instanceof a) {
                a aVar = (a) viewHolder;
                ap.setViewTextColor(aVar.oqT, R.color.CAM_X0302);
                aVar.oqV.setBackgroundDrawable(gradientDrawable);
                SvgManager.bsU().a(aVar.oqU, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }

    private boolean LL(int i) {
        return this.mData != null && this.mData.size() < 20 && i == this.mData.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends RecyclerView.ViewHolder {
        public EditText oqW;
        public ImageView oqX;
        private d oqY;

        public b(View view) {
            super(view);
            this.oqW = (EditText) view.findViewById(R.id.vote_item);
            this.oqX = (ImageView) view.findViewById(R.id.img_delete);
            this.oqY = new d(this);
            this.oqW.setOnEditorActionListener(WriteVoteViewAdapter.this.mOnEditorActionListener);
        }

        public void setPosition(int i) {
            this.oqY.setPosition(i);
            this.oqW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.b.1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        b.this.oqW.addTextChangedListener(b.this.oqY);
                    } else {
                        b.this.oqW.removeTextChangedListener(b.this.oqY);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView oqT;
        public ImageView oqU;
        public RelativeLayout oqV;

        public a(View view) {
            super(view);
            this.oqT = (TextView) view.findViewById(R.id.vote_add_item);
            this.oqU = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.oqV = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class d implements TextWatcher {
        private final b ora;
        private int position;

        public d(b bVar) {
            this.ora = bVar;
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
                String replace = obj.replace(" ", "");
                WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                writeVoteItemData.setId(this.position + 1);
                if (ag.getTextLengthWithEmoji(replace) > 28) {
                    WriteVoteViewAdapter.this.mPageContext.showToast(String.format(WriteVoteViewAdapter.this.mPageContext.getString(R.string.write_vote_toast), 14));
                }
                String subStringWithEmoji = ag.subStringWithEmoji(replace, 28);
                if (!subStringWithEmoji.equals(editable.toString())) {
                    this.ora.oqW.setText(subStringWithEmoji);
                    this.ora.oqW.setSelection(subStringWithEmoji.length());
                }
                writeVoteItemData.setText(subStringWithEmoji);
                WriteVoteViewAdapter.this.oqR.a(writeVoteItemData, this.position);
            }
        }
    }
}
