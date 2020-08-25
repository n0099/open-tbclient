package com.baidu.tieba.sdk.c;

import com.baidu.live.adp.lib.util.StringUtils;
/* loaded from: classes7.dex */
public class a {
    public String bduss;
    public String nickName;
    public String portrait;
    public int sex;
    public String userId;
    public String userName;

    public boolean isValid() {
        return (StringUtils.isNull(this.userId) || StringUtils.isNull(this.bduss)) ? false : true;
    }
}
