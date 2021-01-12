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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class WriteVoteViewAdapter extends RecyclerView.Adapter {
    private List<WriteVoteItemData> mData;
    private TbPageContext mPageContext;
    private c oer;
    private boolean oeq = false;
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
        void Ll(int i);

        void a(WriteVoteItemData writeVoteItemData, int i);

        void dXN();
    }

    public WriteVoteViewAdapter(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<WriteVoteItemData> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void a(c cVar) {
        this.oer = cVar;
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
            bVar.oew.setHint(String.format(this.mPageContext.getString(R.string.write_vote_item), Integer.valueOf(i + 1)));
            bVar.oew.setGravity(19);
            if (i < this.mData.size() - 1) {
                bVar.oew.setImeOptions(5);
            } else {
                bVar.oew.setImeOptions(1);
            }
            ImageView imageView = bVar.oex;
            if (this.mData.size() > 2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteVoteViewAdapter.this.oer != null) {
                        WriteVoteViewAdapter.this.oer.Ll(i);
                    }
                }
            });
            bVar.setPosition(i);
            if (!StringUtils.isNull(text)) {
                bVar.oew.setText(text);
            } else {
                bVar.oew.setText("");
            }
            if (this.oeq && i == this.mData.size() - 1) {
                bVar.oew.requestFocus();
                this.oeq = false;
            }
        } else if (viewHolder instanceof a) {
            a aVar = (a) viewHolder;
            aVar.oet.setText(String.format(this.mPageContext.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.mData.size())));
            aVar.oev.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteVoteViewAdapter.this.oer != null) {
                        WriteVoteViewAdapter.this.oer.dXN();
                        WriteVoteViewAdapter.this.oeq = true;
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
        return !Lm(i) ? 1 : 2;
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
            gradientDrawable.setColor(ao.getColor(R.color.CAM_X0209));
            gradientDrawable.setStroke(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds1), ao.getColor(R.color.CAM_X0603));
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                bVar.oew.setTextColor(ao.getColor(R.color.CAM_X0105));
                bVar.oew.setHintTextColor(ao.getColor(R.color.CAM_X0109));
                bVar.oew.setBackgroundDrawable(gradientDrawable);
                SvgManager.bsx().a(bVar.oex, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else if (viewHolder instanceof a) {
                a aVar = (a) viewHolder;
                ao.setViewTextColor(aVar.oet, R.color.CAM_X0302);
                aVar.oev.setBackgroundDrawable(gradientDrawable);
                SvgManager.bsx().a(aVar.oeu, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }

    private boolean Lm(int i) {
        return this.mData != null && this.mData.size() < 20 && i == this.mData.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends RecyclerView.ViewHolder {
        public EditText oew;
        public ImageView oex;
        private d oey;

        public b(View view) {
            super(view);
            this.oew = (EditText) view.findViewById(R.id.vote_item);
            this.oex = (ImageView) view.findViewById(R.id.img_delete);
            this.oey = new d(this);
            this.oew.setOnEditorActionListener(WriteVoteViewAdapter.this.mOnEditorActionListener);
        }

        public void setPosition(int i) {
            this.oey.setPosition(i);
            this.oew.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.b.1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        b.this.oew.addTextChangedListener(b.this.oey);
                    } else {
                        b.this.oew.removeTextChangedListener(b.this.oey);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView oet;
        public ImageView oeu;
        public RelativeLayout oev;

        public a(View view) {
            super(view);
            this.oet = (TextView) view.findViewById(R.id.vote_add_item);
            this.oeu = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.oev = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class d implements TextWatcher {
        private final b oeA;
        private int position;

        public d(b bVar) {
            this.oeA = bVar;
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
                if (ad.getTextLengthWithEmoji(replace) > 28) {
                    WriteVoteViewAdapter.this.mPageContext.showToast(String.format(WriteVoteViewAdapter.this.mPageContext.getString(R.string.write_vote_toast), 14));
                }
                String subStringWithEmoji = ad.subStringWithEmoji(replace, 28);
                if (!subStringWithEmoji.equals(editable.toString())) {
                    this.oeA.oew.setText(subStringWithEmoji);
                    this.oeA.oew.setSelection(subStringWithEmoji.length());
                }
                writeVoteItemData.setText(subStringWithEmoji);
                WriteVoteViewAdapter.this.oer.a(writeVoteItemData, this.position);
            }
        }
    }
}
