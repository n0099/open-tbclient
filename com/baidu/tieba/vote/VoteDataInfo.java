package com.baidu.tieba.vote;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.PollInfo;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class VoteDataInfo implements f, Serializable {
    private static final long serialVersionUID = -4157201445004088848L;
    private int mEndtime;
    private int mIsMulti;
    private int mIsPolled;
    private List<com.baidu.tbadk.widget.vote.a> mOptions;
    private int mOptionsCount;
    private String mPolledValue;
    private int mStatus;
    private String mTips;
    private long mTotalNum;
    private long mTotalPoll;
    private int mType;

    public int getVoteType() {
        return this.mType;
    }

    public long getTotalPoll() {
        return this.mTotalPoll;
    }

    public void setTotalPoll(long j) {
        this.mTotalPoll = j;
    }

    public long getTotalNum() {
        return this.mTotalNum;
    }

    public void setTotalNum(long j) {
        this.mTotalNum = j;
    }

    public int getOptionsCount() {
        return this.mOptionsCount;
    }

    public void setOptionsCount(int i) {
        this.mOptionsCount = i;
    }

    public int getIsPolled() {
        return this.mIsPolled;
    }

    public void setIsPolled(int i) {
        this.mIsPolled = i;
    }

    public String getPolledValue() {
        return this.mPolledValue;
    }

    public void setPolledValue(String str) {
        this.mPolledValue = str;
    }

    public String getTips() {
        return this.mTips;
    }

    public void setTips(String str) {
        this.mTips = str;
    }

    public int getIsMulti() {
        return this.mIsMulti;
    }

    public int getEndtime() {
        return this.mEndtime;
    }

    public List<com.baidu.tbadk.widget.vote.a> getOptions() {
        return this.mOptions;
    }

    public void setOptions(List<com.baidu.tbadk.widget.vote.a> list) {
        this.mOptions = list;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public void parserProtobuf(PollInfo pollInfo) {
        String[] strArr;
        if (pollInfo != null) {
            this.mType = pollInfo.type.intValue();
            this.mIsMulti = pollInfo.is_multi.intValue();
            this.mTotalNum = pollInfo.total_num.longValue();
            this.mOptionsCount = pollInfo.options_count.intValue();
            this.mIsPolled = pollInfo.is_polled.intValue();
            this.mPolledValue = pollInfo.polled_value;
            this.mTips = pollInfo.tips;
            this.mEndtime = pollInfo.end_time.intValue();
            this.mStatus = pollInfo.status.intValue();
            this.mOptions = new ArrayList();
            if (TextUtils.isEmpty(this.mPolledValue)) {
                strArr = null;
            } else {
                strArr = this.mPolledValue.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            List<PollOption> list = pollInfo.options;
            if (list != null) {
                long j = 0;
                for (PollOption pollOption : list) {
                    if (pollOption != null) {
                        j = pollOption.num.longValue() + j;
                    }
                }
                this.mTotalPoll = j;
                for (PollOption pollOption2 : list) {
                    if (pollOption2 != null) {
                        b bVar = new b(pollOption2.id.intValue(), pollOption2.text, pollOption2.image, pollOption2.num.longValue());
                        if (this.mTotalPoll > 0) {
                            bVar.setPercent((int) ((pollOption2.num.longValue() * 100) / this.mTotalPoll));
                        }
                        if (b(strArr, String.valueOf(pollOption2.id))) {
                            bVar.setSelected(true);
                        }
                        this.mOptions.add(bVar);
                    }
                }
            }
        }
    }

    private boolean b(String[] strArr, String str) {
        if (strArr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return PostData.ggw;
    }
}
