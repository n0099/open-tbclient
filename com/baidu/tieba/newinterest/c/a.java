package com.baidu.tieba.newinterest.c;

import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.tieba.newinterest.data.b> lja = new ArrayList();

    public a() {
        dgl();
    }

    private void dgl() {
        this.lja.add(new com.baidu.tieba.newinterest.data.b(1, "游戏", R.drawable.ic_icon_mask_guide_game_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(2, "生活", R.drawable.ic_icon_pure_module_life_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(3, "动漫", R.drawable.ic_icon_pure_module_comic_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(4, "文学", R.drawable.ic_icon_pure_module_literatue_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(5, "科学", R.drawable.ic_icon_pure_module_science_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(6, "动植物", R.drawable.ic_icon_mask_guide_leaf_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(7, "明星", R.drawable.ic_icon_mask_guide_star_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(8, "情感", R.drawable.ic_icon_mask_guide_motion_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(9, "体育", R.drawable.ic_icon_mask_guide_sport_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(10, "科技", R.drawable.ic_icon_mask_guide_tech_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(11, "影视", R.drawable.ic_icon_mask_guide_movie_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(12, "教育", R.drawable.ic_icon_mask_guide_education_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(13, "旅游", R.drawable.ic_icon_mask_guide_travel_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(14, "文化艺术", R.drawable.ic_icon_mask_guide_art_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(15, "社会", R.drawable.ic_icon_mask_guide_social_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(16, "美食", R.drawable.ic_icon_mask_guide_food_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(17, "实事", R.drawable.ic_icon_mask_guide_current_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(18, "时尚", R.drawable.ic_icon_mask_guide_fasion_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(19, "搞笑", R.drawable.ic_icon_mask_guide_funny_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(20, "汽车", R.drawable.ic_icon_mask_guide_car_svg, false));
        this.lja.add(new com.baidu.tieba.newinterest.data.b(21, "企业", R.drawable.ic_icon_mask_guide_company_svg, false));
    }

    public static int FR(int i) {
        switch (i) {
            case 1:
                return R.drawable.ic_icon_mask_guide_game_svg;
            case 2:
                return R.drawable.ic_icon_pure_module_life_svg;
            case 3:
                return R.drawable.ic_icon_pure_module_comic_svg;
            case 4:
                return R.drawable.ic_icon_pure_module_literatue_svg;
            case 5:
                return R.drawable.ic_icon_pure_module_science_svg;
            case 6:
                return R.drawable.ic_icon_mask_guide_game_svg;
            case 7:
                return R.drawable.ic_icon_mask_guide_star_svg;
            case 8:
                return R.drawable.ic_icon_mask_guide_motion_svg;
            case 9:
                return R.drawable.ic_icon_mask_guide_sport_svg;
            case 10:
                return R.drawable.ic_icon_mask_guide_tech_svg;
            case 11:
                return R.drawable.ic_icon_mask_guide_movie_svg;
            case 12:
                return R.drawable.ic_icon_mask_guide_education_svg;
            case 13:
                return R.drawable.ic_icon_mask_guide_travel_svg;
            case 14:
                return R.drawable.ic_icon_mask_guide_art_svg;
            case 15:
                return R.drawable.ic_icon_mask_guide_social_svg;
            case 16:
                return R.drawable.ic_icon_mask_guide_food_svg;
            case 17:
                return R.drawable.ic_icon_mask_guide_current_svg;
            case 18:
                return R.drawable.ic_icon_mask_guide_fasion_svg;
            case 19:
                return R.drawable.ic_icon_mask_guide_funny_svg;
            case 20:
                return R.drawable.ic_icon_mask_guide_car_svg;
            case 21:
                return R.drawable.ic_icon_mask_guide_company_svg;
            default:
                return -1;
        }
    }

    public List<com.baidu.tieba.newinterest.data.b> dgm() {
        return this.lja;
    }
}
