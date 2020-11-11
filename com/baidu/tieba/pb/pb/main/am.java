package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class am extends PostData {
    public static final BdUniqueId lzt = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ay lzu;
    public com.baidu.tbadk.core.data.ay lzv;
    public com.baidu.tbadk.core.data.ay lzw;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lzt;
    }

    public boolean hasData() {
        if (this.lzu == null || StringUtils.isNull(this.lzu.summary)) {
            if (this.lzv == null || StringUtils.isNull(this.lzv.summary)) {
                return (this.lzw == null || StringUtils.isNull(this.lzw.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
