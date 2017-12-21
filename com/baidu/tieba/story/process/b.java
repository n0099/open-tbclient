package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public int eZm;
    public long forumId;
    public String forumName;
    public String gwk;
    public String gwl;
    public String gwm;
    public String gwn;
    public int gwr;
    public int gws;
    public int gwt;
    public int gwu;
    public String gwv;
    public int state;
    public String timestamp;
    public int type;
    public boolean gwi = false;
    public boolean gwo = false;
    public boolean gwp = false;
    public boolean gwq = true;

    public void Z(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gwk = intent.getStringExtra("key_input_picture_path");
            this.gwl = intent.getStringExtra("key_input_video_path");
            this.gwn = intent.getStringExtra("key_sticker_path");
            this.gwi = intent.getBooleanExtra("key_need_mute", false);
            this.gwo = intent.getBooleanExtra("key_need_publish", false);
            this.eZm = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.gwp = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gwq = intent.getBooleanExtra("key_need_composite", true);
            this.gwv = TbadkCoreApplication.getCurrentAccount();
            this.gwr = intent.getIntExtra("key_target_width", 0);
            this.gws = intent.getIntExtra("key_target_height", 0);
            this.gwt = intent.getIntExtra("key_locate_x", 0);
            this.gwu = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
