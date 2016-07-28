package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class ds extends com.baidu.tieba.tbadkCore.data.s {
    public static final BdUniqueId eet = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.al eeu;
    public com.baidu.tbadk.core.data.al eev;
    public com.baidu.tbadk.core.data.al eew;

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eet;
    }

    public boolean hasData() {
        if (this.eeu == null || StringUtils.isNull(this.eeu.summary)) {
            if (this.eev == null || StringUtils.isNull(this.eev.summary)) {
                return (this.eew == null || StringUtils.isNull(this.eew.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
