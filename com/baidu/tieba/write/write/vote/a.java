package com.baidu.tieba.write.write.vote;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PollOptionData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private VoteView ail;
    private TbPageContext<WriteActivity> mPageContext;
    private RelativeLayout mRootView;
    private WriteVoteData mWriteVoteData;

    public a(TbPageContext<WriteActivity> tbPageContext, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.mRootView = relativeLayout;
        this.ail = new VoteView(this.mPageContext.getPageActivity());
        this.ail.setPageContext(this.mPageContext);
        this.ail.setDeleteOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.mPageContext.getPageActivity());
                aVar.zU(a.this.mPageContext.getString(R.string.vote_delete_dialog_title));
                aVar.setTitleShowCenter(true);
                aVar.zV(a.this.mPageContext.getString(R.string.vote_delete_dialog_message));
                aVar.setMessageShowCenter(true);
                aVar.a(R.string.delete, new a.b() { // from class: com.baidu.tieba.write.write.vote.a.1.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.mWriteVoteData = null;
                        a.this.xG(false);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.vote.a.1.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.mPageContext).bia();
            }
        });
        this.ail.setVoteViewDeleteVisibility(0);
        this.mRootView.addView(this.ail);
        xG(false);
    }

    public void ao(View.OnClickListener onClickListener) {
        if (this.ail != null && onClickListener != null) {
            this.ail.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        if (this.ail != null && onClickListener != null) {
            this.ail.setOnItemClickListener(onClickListener);
        }
    }

    public void xG(boolean z) {
        this.mRootView.setVisibility(z ? 0 : 8);
    }

    public void b(WriteVoteData writeVoteData) {
        if (writeVoteData != null && this.ail != null) {
            this.mWriteVoteData = writeVoteData;
            this.ail.setVoteTitle(this.mWriteVoteData.getTitle());
            String string = this.mWriteVoteData.getIsMulti() == 1 ? this.mPageContext.getString(R.string.vote_type_multiple) : this.mPageContext.getString(R.string.vote_type_single);
            int expireType = this.mWriteVoteData.getExpireType();
            String str = "";
            if (expireType > 0) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(6, expireType);
                str = String.format(this.mPageContext.getString(R.string.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
            }
            if (StringUtils.isNull(str)) {
                this.ail.setVoteSubContent(string);
            } else {
                this.ail.setVoteSubContent(string + " · " + str);
            }
            ArrayList arrayList = new ArrayList();
            for (WriteVoteItemData writeVoteItemData : this.mWriteVoteData.getOptions()) {
                PollOptionData pollOptionData = new PollOptionData();
                pollOptionData.setId(writeVoteItemData.getId());
                pollOptionData.setText(writeVoteItemData.getText());
                arrayList.add(pollOptionData);
            }
            if (!y.isEmpty(arrayList)) {
                if (arrayList.size() > 3) {
                    this.ail.setData(arrayList.subList(0, 3));
                } else {
                    this.ail.setData(arrayList);
                }
            }
        }
    }

    public WriteVoteData getWriteVoteData() {
        return this.mWriteVoteData;
    }

    public void onChangeSkinType(int i) {
        this.ail.onChangeSkinType(i);
    }
}
